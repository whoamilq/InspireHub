package com.chat_blog.myblog.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Result<T> {
    private Integer code = 200;
    private String msg = "sucess";
    private T data;

    public static Result<Object> success()
    {
        return new Result<>(200, "sucess", null);
    }
    public static <T> Result<T> success(T data){
        return new Result<>(200, "sucess", data);
    }

    public static Result<Object> fail(){
        return new Result<>(404, "fail", null);
    }

    public static <T> Result<T> fail(T data){
        return new Result<>(404, "fail", data);
    }
    public static <T> Result<T> fail(String msg){
        return new Result<>(404, msg, null);
    }
    public static <T> Result<T> fail(Integer code, String msg){
        return new Result<>(code, msg, null);
    }



}
