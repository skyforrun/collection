package com.handwrite.queue;

/**
 * 队列相关操作
 */
public interface queue {

    //大小
    public int size();

    //是否为空
    public boolean isEmpty();

    //入队列
    public void inqueue(Object object);

    //出队列
    public Object outqueue();

    //查看队头元素
    public Object peak();
}
