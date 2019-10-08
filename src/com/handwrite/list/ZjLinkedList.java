package com.handwrite.list;

import com.handwrite.entity.Node;

/**
 * @ProjectName: collection
 * @Package: com.handwrite
 * @ClassName: ZjLinkedList
 * @Author: zj
 * @Description: 手写linkedlist
 * @Date: 2019/7/21 17:25
 * @Version: 1.0
 */
public class ZjLinkedList {
     Node first;
     Node last;
     int size;

    public ZjLinkedList() {
    }

    /**
     * 检查索引是否越界
     * @param index
     */
    public void rangeCheck(int index){
        if (index<0||index>=size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("索引越界"+"---->"+index);
            }
        }
    }

    /**
     * 链表添加元素
     * @param obj 添加的元素
     */
    public void add(Object obj){
        Node node = new Node();
        //当链表首为空
        if (first==null){
            node.setPrevious(null);
            node.setObject(obj);
            node.setNext(null);

            first=node;
            last=node;//不知道下一个节点是什么
        }else {
            //链表向last节点后增加新的节点
            node.setPrevious(last);
            node.setObject(obj);
            node.setNext(null);

            last.setNext(node);
            last=node;
        }
        size++;
    }

    /**
     * 返回指定位置的节点
     * @return
     */
    public Node node(int index){
        Node temp = null;
       if (first!=null){
            temp = first;
            for (int i = 0;i<index;i++){
                temp = temp.next;
            }
        }
        return temp;
    }

    /**
     * linkedlist根据索引取值
     * @param index
     * @return
     */
    public Object get(int index){
        rangeCheck(index);
        Node temp = node(index);
        if (temp!=null) {
            return temp.object;
        }
        return null;
    }

    /**
     * linkedlist删除元素
     * @param index
     */
    public void remove(int index){
        rangeCheck(index);
        Node temp = node(index);

        if (temp!=null){
            Node up = temp.previous;//删除元素的前指针指向上一节点
            Node down = temp.next;//删除元素的后指针指定下一节点
            up.next = down;//上节点的后指针指向下节点
            down.previous = up;//下一级店的前指针指向上一节点
        }
        size--;
    }

    /**
     * 在指定的位置插入指定的元素
     * @param index
     * @param object
     */
    public void add(int index,Object object){
        rangeCheck(index);
        Node temp = node(index);

        Node newNode = new Node();
        newNode.object = object;

        if (temp!=null){
            Node up = temp.previous; //指定位置的前指针指向上一节点
            up.next = newNode; //上一节点的后指针指向新节点
            newNode.previous = up;//新节点的前指针指向上一节点
            newNode.next = temp;//新节点的后指针指向指定位置的节点
            temp.previous = newNode;//指定位置节点的前指针指向新节点
        }
        size++;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        ZjLinkedList linkedList = new ZjLinkedList();
        linkedList.add(1);
        linkedList.add("2");
        linkedList.add("qq");
        linkedList.add(22);

        //linkedList.remove(1);
        linkedList.add(3,"哈哈哈");
        for (int i=0;i<linkedList.size();i++) {
            System.out.println(linkedList.get(i));
        }
    }
}

