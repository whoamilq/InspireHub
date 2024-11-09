package com.chat_blog.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chat_blog.myblog.pojo.ChatgptMessage;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author ChatViewer
 */
@Mapper
public interface ChatgptMessageMapper extends BaseMapper<ChatgptMessage> {
}
