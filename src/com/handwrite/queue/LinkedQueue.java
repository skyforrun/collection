package com.handwrite.queue;

public class LinkedQueue implements Queue{
    private int size;
    private Node head;
    private Node tail;

    public LinkedQueue(){
        this.tail = null;
        this.size = 0;
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
        Node prev = tail;
        tail = new Node(object,null);

        if (size==0){
            head = tail;
        }else {
            prev.next = tail;
        }

        size++;
    }

    @Override
    public Object outqueue() {
        if (size==0){
            throw new RuntimeException("队列是空的");
        }
        Object obj = head.data;
        head = head.next;
        size--;

        if (size==0){
            tail = null;
        }
        return obj;
    }

    @Override
    public Object peak() {
        if (size==0){
            throw new RuntimeException("队列是空的");
        }
        return head.data;
    }

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

    public static void main(String[] args) {
        Queue queue = new LinkedQueue();
        for (int i=0;i<100;i++){
            queue.inqueue(i+1);
        }

        int size = queue.size();
        for (int i = 0;i<size;i++){
            System.out.println("队列的元素出队的元素为"+queue.outqueue());

        }
    }
}
