package com.example.learningreview.standard;

public interface ResultType {
    String getResultCode();
    String getMsg();
    default <T> T getData() {
        return null;
    }
}
