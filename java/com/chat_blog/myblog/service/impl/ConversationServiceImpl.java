package com.chat_blog.myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chat_blog.myblog.dto.ConversationDto;
import com.chat_blog.myblog.exception.NoPermissionException;
import com.chat_blog.myblog.mapper.AnswerMapper;
import com.chat_blog.myblog.mapper.ChatgptMessageMapper;
import com.chat_blog.myblog.mapper.ConversationMapper;
import com.chat_blog.myblog.pojo.ChatgptMessage;
import com.chat_blog.myblog.pojo.Conversation;
import com.chat_blog.myblog.service.ConversationService;
import com.chat_blog.myblog.utils.ContextHolderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ChatViewer
 */
@Slf4j
@Service
public class ConversationServiceImpl extends ServiceImpl<ConversationMapper, Conversation> implements ConversationService {

    @Resource
    ConversationMapper conversationMapper;

    @Resource
    ChatgptMessageMapper chatgptMessageMapper;

    @Resource
    AnswerMapper answerMapper;


    @Override
    public List<ConversationDto> conversationsOf(Long userId) {
        return conversationMapper.conversationsOf(userId);
    }


    @Override
    public Long createConversation(Conversation conversation) {
        // 设置创建人
        conversation.setUserId(ContextHolderUtil.getUserId());
        // 设置创建时间
        conversation.setCreateTime(LocalDateTime.now());
        // 存储
        save(conversation);
        // 返回Id
        return conversation.getConversationId();
    }


    @Override
    public void deleteWithMsg(Long conversationId) {

        // 校验该会话是否属于当前登录用户
        Long userId = ContextHolderUtil.getUserId();
        Conversation conversation = getById(conversationId);
        if (userId == null) {
            throw new NoPermissionException("用户未登录！不能删除会话！");
        }
        if (!userId.equals(conversation.getUserId())) {
            throw new NoPermissionException("不能删除其他用户的会话！");
        }

        // 删除相关消息记录
        LambdaQueryWrapper<ChatgptMessage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ChatgptMessage::getConversationId, conversationId);
        chatgptMessageMapper.delete(lambdaQueryWrapper);

        // 如果是题目列表中的消息，还需要把相应字段设置为null
        if (conversation.getConversationType() == 1) {
            answerMapper.clearConversation(conversationId);
        }

        // 删除会话本身
        removeById(conversationId);
    }

}
