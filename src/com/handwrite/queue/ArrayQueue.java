package com.handwrite.queue;

public class ArrayQueue implements Queue {

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
        if (data.length==size){
            grow(data.length*2);
        }
        //当容量满了有可能越界的时候(环形)
        tail = (tail+1)%data.length;
        data[tail] = object;

        if (size==0){
            head = tail;
        }

        size++;
    }

    private void grow(int capacity) {
        if (capacity<=DEFAULT_CAPACITY){
            return;
        }

        Object[] oldData = data;
        data = new Object[capacity];

        //环形捋直
        for (int i = 0;i<size;i++){
            data[i] = oldData[(head+i)%oldData.length];
        }

        head = 0;
        tail = size-1;
    }

    @Override
    public Object outqueue() {
        if (size == 0){
            throw new RuntimeException("这是一个空栈");
        }

        Object obj = data[head];
        //head往后挪的时候超过数组大小，取模
        head = (head+1)%data.length;
        size--;

        if (size<data.length/2){
            grow(data.length/2);
        }
        return obj;
    }

    @Override
    public Object peak() {
        if (size == 0){
            throw new RuntimeException("这是一个空栈");
        }
        return data[head];
    }

    public static void main(String[] args) {
        Queue queue = new ArrayQueue();
        for (int i=0;i<100;i++){
            queue.inqueue(i+1);
        }

        int size = queue.size();
        for (int i = 0;i<size;i++){
            System.out.println("队列的元素出队的元素为"+queue.outqueue());

        }
    }
}
