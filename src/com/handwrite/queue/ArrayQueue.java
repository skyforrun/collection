package com.handwrite.queue;

public class ArrayQueue implements queue{

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;
    private int head;
    private int tail;

    public ArrayQueue(int capacity){
        this.data = new Object[capacity];
        this.size = 0;
        this.head = -1;
        this.tail = -1;
    }

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void inqueue(Object object) {

    }

    @Override
    public Object outqueue() {
        return null;
    }

    @Override
    public Object peak() {
        return null;
    }
}
