package com.handwrite;

/**
 * @ProjectName: collection
 * @Package: com.handwrite
 * @ClassName: ZjArrayList
 * @Author: zj
 * @Description: 手写list集合
 * @Date: 2019/7/20 16:22
 * @Version: 1.0
 */
public class ZjArrayList {

    private Object[] elementDate;
    private int size;//容器大小

    //大小
    public int size(){
        return size;
    }
    //是否为空
    public boolean isEmpty(){
        return size==0;
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

    public ZjArrayList() {
        this(10);
    }

    public ZjArrayList(int initSize){
        if (initSize<0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementDate = new Object[initSize];
    }

    /**
     * arraylist的添加元素
     */
    public void add(Object obj){
        //数组扩容
        if (size==elementDate.length) {
            Object[] newArrayList = new Object[size*2];
            //数据的拷贝
            System.arraycopy(elementDate,0,newArrayList,0,elementDate.length);
           /* for (int i = 0;i<elementDate.length;i++){
                newArrayList[i]=elementDate[i];
            }*/
            elementDate=newArrayList;
        }
        elementDate[size++]=obj;
    }

    /**
     * 向指定位置上添加元素
     * @param index
     * @param obj
     */
    public void addElement(int index,Object obj){
        //省略扩容
        System.arraycopy(elementDate, index, elementDate, index + 1,
                size - index);
        elementDate[index] = obj;
        size++;
    }

    /**
     * 查找元素
     * @param index
     */
    public Object get(int index){
        rangeCheck(index);
        return elementDate[index];
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     */
    public void fastRemove(int index){
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            //被复制的数组，被复制的索引位置，复制到的数组，复制的索引，复制的长度
            //arrayCopy( arr1, 2, arr2, 5, 10);
            //意思是;将arr1数组里从索引为2的元素开始, 复制到数组arr2里的索引为5的位置, 复制的元素个数为10个.
            System.arraycopy(elementDate, index+1, elementDate, index,
                    numMoved);
        elementDate[--size] = null; // clear to let GC do its work

    }

    public void remove(Object obj){
        for (int i = 0;i<size;i++){
            if (get(i).equals(obj)){
                fastRemove(i);
            }
        }
    }

    /**
     * arraylist的修改,与源码那样有何不同？
     * @param index  位置
     * @param obj  元素
     * @return
     */
    public void set(int index,Object obj){
        rangeCheck(index);
        elementDate[index] = obj;
        //Object value = elementDate[index];
        //return value;
    }

    public static void main(String[] args) {
        ZjArrayList zjArrayList = new ZjArrayList(3);
        zjArrayList.add("你好啊");
        zjArrayList.add(2222);
        zjArrayList.add("23");
        zjArrayList.add("24");
        System.out.println(zjArrayList.size);
        //System.out.println(zjArrayList.get(4));
        zjArrayList.set(2,"为什么");
        zjArrayList.remove("24");

        for(int i=0;i<zjArrayList.size;i++){
            System.out.println(zjArrayList.get(i));
        }
    }
}
