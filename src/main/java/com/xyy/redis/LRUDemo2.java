package com.xyy.redis;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-17 11:51
 **/
public class LRUDemo2 {

    /**
     * 构造node作为数据载体
     */
    class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    //构造一个双向队列，存放node
    class DoubleLinkedList<K,V>{
        Node<K,V> head;
        Node<K,V> tail;

        public DoubleLinkedList(){
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //添加到头
        public void addHead(Node<K,V> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //删除节点
        public void removeNode(Node<K,V> node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;

        }

        //获得最后一个节点
        public Node getLast(){
            return tail.prev;
        }
    }

    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUDemo2(int size){
        this.cacheSize = size;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int getKey(Integer key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node<Integer,Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node<Integer,Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if(map.size() == cacheSize){
                Node<Integer,Integer> node = doubleLinkedList.getLast();
                map.remove(node.key);
                doubleLinkedList.removeNode(node);
            }
            Node<Integer,Integer> newNode = new Node<>(key,value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }
    }


    public static void main(String[] args) {
        LRUDemo2 lruDemo = new LRUDemo2(3);
        lruDemo.put(1,1);
        lruDemo.put(2,1);
        lruDemo.put(3,1);
        System.out.println(lruDemo.map.keySet());
        lruDemo.put(4,4);
        System.out.println(lruDemo.map.keySet());
        lruDemo.put(3,2);
        System.out.println(lruDemo.map.keySet());
        lruDemo.put(3,2);
        System.out.println(lruDemo.map.keySet());
        lruDemo.put(5,5);
        System.out.println(lruDemo.map.keySet());
    }
}
