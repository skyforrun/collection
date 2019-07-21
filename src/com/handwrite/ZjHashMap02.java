package com.handwrite;

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
    Entry[] entries = new Entry[999];
    int size;

    public void put(Object key,Object value){
        Entry e = new Entry(key,value);


    }
}
