package com.handwrite.map;

import com.handwrite.entity.Dog;
import com.handwrite.entity.Entry;

/**
 * @ProjectName: collection
 * @Package: com.handwrite
 * @ClassName: ZjHashMap01
 * @Author: zj
 * @Description: 手写hashmap，索引效率低
 * @Date: 2019/7/20 19:12
 * @Version: 1.0
 */
public class ZjHashMap01 {
    Entry[] entries = new Entry[999];
    int size;

    /**
     * map的插入存值
     * @param key
     * @param value
     */
    public void put(Object key,Object value){
        Entry e = new Entry(key,value);

        //key相同时吧value覆盖,键不能重复
        for (int i=0;i<size;i++){
            if (entries[i].key.equals(key)) {
                entries[i].value = value;
                //return;  ?
            }
        }

        entries[size++] = e;
    }

    /**
     * map根据键来取值
     * @param key
     * @return
     */
    public Object get(Object key){
        for (int i=0;i<size;i++){
            if (entries[i].key.equals(key)) {
                return entries[i].value;
            }
        }
        return null;
    }

    /**
     * 是否含有指定的键key
     * @param key
     * @return
     */
    public boolean containsKey(Object key){
        for (int i=0;i<size;i++){
            if (entries[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ZjHashMap01 zjHashMap = new ZjHashMap01();
        zjHashMap.put("1","111");
        zjHashMap.put("2",222);
        zjHashMap.put("礼",new Dog("mike"));
        zjHashMap.put("礼",new Dog("nike"));
        Dog dog = (Dog) zjHashMap.get("礼");
        System.out.println(dog.name);
    }
}

