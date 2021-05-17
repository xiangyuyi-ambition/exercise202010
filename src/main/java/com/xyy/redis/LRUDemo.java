package com.xyy.redis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-17 11:12
 **/
public class LRUDemo<K,V> extends LinkedHashMap<K,V> {

    private int  capacity;

    /**
     * * @param  accessOrder     the ordering mode - <tt>true</tt> for
     *      *         access-order, <tt>false</tt> for insertion-order
     * @param capacity
     */
    public LRUDemo( int capacity) {
        super(capacity, 0.75f,false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUDemo lruDemo = new LRUDemo(3);
        lruDemo.put(1,"a");
        lruDemo.put(2,"a");
        lruDemo.put(3,"a");
        System.out.println(lruDemo.keySet());
        lruDemo.put(4,"d");
        System.out.println(lruDemo.keySet());
        lruDemo.put(3,"c");
        System.out.println(lruDemo.keySet());
        lruDemo.put(3,"c");
        System.out.println(lruDemo.keySet());
        lruDemo.put(3,"c");
        System.out.println(lruDemo.keySet());
        lruDemo.put(5,"x");
        System.out.println(lruDemo.keySet());
    }
}

/**
 * true
 *[1, 2, 3]
 * [2, 3, 4]
 * [2, 4, 3]
 * [2, 4, 3]
 * [2, 4, 3]
 * [4, 3, 5]
 */
