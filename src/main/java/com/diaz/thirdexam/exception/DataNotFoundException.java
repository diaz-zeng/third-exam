package com.diaz.thirdexam.exception;

public class DataNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "未找到相关数据";
    }
}
