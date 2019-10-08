package com.handwrite.entity;

/**
 * @ProjectName: collection
 * @Package: com.handwrite
 * @ClassName: Node
 * @Author: zj
 * @Description: 链表节点
 * @Date: 2019/7/21 17:27
 * @Version: 1.0
 */
public class Node {
     public Node previous;
     public Object object;
     public Node next;

    public Node() {
    }

    public Node getPrevious() {
        return previous;
    }

    public Node setPrevious(Node previous) {
        this.previous = previous;
        return this;
    }

    public Object getObject() {
        return object;
    }

    public Node setObject(Object object) {
        this.object = object;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }
}
