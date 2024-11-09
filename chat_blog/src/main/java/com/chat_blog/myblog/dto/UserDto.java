package com.chat_blog.myblog.dto;

import lombok.Data;

/**
 * @author ChatViewer
 */
@Data
public class UserDto {

    private Long userId;

    private String userName;

    private String userAvatar;

    private Integer userTokenCount;

    private String userApiKey;

}