package com.handwrite.stack;

public interface Stack {
    boolean isempty();

    int size();

    //入栈
    void push(Object object);

    //出栈
    Object pop();

    //栈顶元素
    Object peak();
}
