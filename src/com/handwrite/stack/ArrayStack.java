package com.handwrite.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack implements Stack{

    /**
     * 默认数组大小
     */
    private final static int DEFAULT_CAPACITY = 10;

    /**
     * 数组
     */
    private Object[] data;

    /**
     * 大小
     */
    private int size;

    /**
     * 栈顶索引
     */
    private int top;

    public ArrayStack(int capacity){
        this.data = new Object[capacity];
        this.size = 0;
        this.top = -1;
    }

    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isempty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(Object object) {
        if (size == data.length){
            grow(data.length*2);
        }

        size++;
        data[++top] = object;
    }

    /**
     * 缩容或者扩容
     * @param capacity
     */
    private void grow(int capacity) {
        //小于默认大小不用缩容
        if (capacity<=DEFAULT_CAPACITY){
            return;
        }
        data = Arrays.copyOf(data,capacity);
    }

    @Override
    public Object pop() {
        if (size == 0){
            throw new EmptyStackException();
        }
        if (size<data.length/2){
            grow(data.length/2);
        }
        size--;
        return data[top--];
    }

    @Override
    public Object peak() {
        if (size == 0){
            throw new EmptyStackException();
        }
        return data[top];
    }

    public static void main(String[] args) {
        Stack arrayStack = new ArrayStack();

        for (int i=0;i<100;i++){
            arrayStack.push(i+1);
        }

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());

        int size1 = arrayStack.size();

        for (int i=0;i<size1;i++){
            System.out.println("出栈之后，栈里的元素为:"+arrayStack.pop());
        }
    }
}
