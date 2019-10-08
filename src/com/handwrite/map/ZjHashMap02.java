package com.handwrite.map;

import com.handwrite.entity.Entry;

import java.util.LinkedList;

/**
 * @ProjectName: collection
 * @Package: com.handwrite
 * @ClassName: ZjHashMap02
 * @Author: zj
 * @Description: 1.解决索引查询效率低的问题
 * @Date: 2019/7/21 16:56
 * @Version: 1.0
 */
public class ZjHashMap02 {
    LinkedList[] arr = new LinkedList[999];
    int size;

    /**
     * map添加元素的操作
     * @param key
     * @param value
     */
    public void put(Object key,Object value){
        Entry e = new Entry(key,value);

        int hash = key.hashCode()%999;
        //链表为空
        if (arr[hash]==null){
            LinkedList ls = new LinkedList();
            arr[hash] = ls;
            ls.add(e);
        }else {
            //不为空,key相同时进行覆盖
            LinkedList list = arr[hash];
            for (int i = 0;i<list.size();i++){
                Entry entry = (Entry) list.get(i);
                if (entry.key.equals(key)){
                    entry.value = value;
                    return;
                }
            }
            arr[hash].add(e);
        }

    }


    public Object get(Object key){
        int hash = key.hashCode()%999;
        if (arr[hash]!=null){
            LinkedList list = arr[hash];
            for (int i = 0;i<list.size();i++){
                Entry entry = (Entry) list.get(i);
                if (entry.key.equals(key)){
                    return entry.value;
                }
            }
        }
        return null;
    }
}
