package com.handwrite.stack;

import jdk.jfr.events.ThrowablesEvent;

import java.util.EmptyStackException;

public class LinkedStack implements Stack{
    /**
     * 节点内部类
     * @return
     */
    private static class Node{
        private Object data;
        private Node next;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node() {
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public LinkedStack(){
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean isempty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(Object object) {
        top = new Node(object,top);
        size++;
    }

    @Override
    public Object pop() {
        if (size==0){
            throw new EmptyStackException();
        }
        Object obj = top.data;
        top = top.next;
        size--;
        return obj;
    }

    @Override
    public Object peak() {
        if (size==0){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack linkedStack= new LinkedStack();
        for (int i = 0;i<5;i++){
            linkedStack.push(i+1);
        }
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());

        int size = linkedStack.size();
        for (int i = 0;i<size;i++){
            System.out.println("弹出之后，栈里面的元素为："+linkedStack.pop());
        }
    }
}
