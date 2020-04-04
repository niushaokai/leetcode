package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author niushaokai
 * @date 2020/1/12
 */
class LRUCache {
    private int capacity;
    private Map<Integer,Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null){
            return -1;
        }else {
            return value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.put(key,value);
        }else {
            if (map.size() == capacity){
                map.remove(0);
                map.put(key,value);
            }else {
                map.put(key,value);
            }
        }
    }
}