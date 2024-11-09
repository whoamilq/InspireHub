package com.chat_blog.myblog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chat_blog.myblog.dto.UserDtoForComment;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author ChatViewer
 */
@Data
@TableName(value ="blog_user")
public class User {

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String userName;

    private String userPhone;

    private String userPassword;

    private String userAvatar;

    private Integer userTokenCount;

    private String userApiKey;

    public UserDtoForComment toUseDtoForComment() {
        UserDtoForComment userDtoForComment = new UserDtoForComment();
        userDtoForComment.setUsername(userName);
        userDtoForComment.setAvatar(userAvatar);
        return userDtoForComment;
    }

}
