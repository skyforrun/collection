package com.handwrite.recursive;

/**
 * 递归求和
 */

public class SumRecursive {

    private static class Node{
        private Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this(data,null);
        }
    }

    /**
     * 常规求和
     * @param start
     * @param end
     * @param arr
     * @return
     */
    public static int sum(int start,int end,int[] arr ){
        if (start == end){
            return start;
        }
        return arr[start]+sum(start+1,end,arr);
    }

    /**
     * 基于链表递归求和
     * @param list
     * @return
     */
    public static int listSum(Node list){
        if (list ==null){
            return 0;
        }

        return 1+listSum(list.next);
    }

    /**
     * 正向打印
     * @param list
     */
    public static void printList(Node list){
        if (list ==null){
            return ;
        }

        System.out.println(list.data);
        printList(list.next);
    }

    /**
     * 反向打印
     * @param list
     */
    public static void printListReverst(Node list){
        if (list ==null){
            return ;
        }

        printList(list.next);
        System.out.println(list.data);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 5, 6};
        Node node1 = null;
        Node node2 = null;
        Node node3 = null;
        Node node4 = null;
        Node node5 = null;
        Node node = new Node(1, node1);
        node1 = new Node(2, node2);
        node2 = new Node(3, node3);
        node3 = new Node(4, node4);
        node4 = new Node(5, node5);
        node5 = new Node(6, null);

        //System.out.println(args[0]+" "+args[1]);
        System.out.println(SumRecursive.sum(1, 4, a));
        SumRecursive.printList(node);
    }
}
