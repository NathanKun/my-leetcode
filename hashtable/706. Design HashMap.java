// https://leetcode.com/problems/design-hashmap/


// Solution 1
class MyHashMap {
    private int[] array = new int[1000001];
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        for (int i = 0; i < 1000001; i++) {
            array[i] = -1;
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        array[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return array[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        array[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
 
 
// Solution 2
class MyHashMap {
    private List<int[]> list;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new ArrayList();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        boolean found = false;
        for (int[] pair : list) {
            if (pair[0] == key) {
                found = true;
                pair[1] = value;
            }
        }
        
        if (!found) {
            list.add(new int[] {key, value});
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for (int[] pair : list) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int iRemove = -1;
        
        for (int i = 0; i < list.size(); i++) {
            int[] pair = list.get(i);
            
            if (pair[0] == key) {
                iRemove = i;
                break;
            }
        }
            
        if (iRemove >= 0) {
            list.remove(iRemove);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
