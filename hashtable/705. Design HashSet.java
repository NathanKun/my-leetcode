// https://leetcode.com/problems/design-hashset/
class MyHashSet1 { // 	119 ms

    private boolean[] set = new boolean[1000000];
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 
 class MyHashSet2 { // 489 ms

    private List<Integer> set;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new ArrayList();
    }
    
    public void add(int key) {
        if (!set.contains(key)) {
            set.add(key);
        }
    }
    
    public void remove(int key) {
        set.remove(Integer.valueOf(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 
 
 class MyHashSet3 { // 129 ms

    private boolean[][] table = new boolean[1000][1000];
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    private int row (int key) {
        return key % 1000;
    }
    
    private int col (int key) {
        return key / 1000;
    }
    
    public void add(int key) {
        table[row(key)][col(key)] = true;
    }
    
    public void remove(int key) {
        table[row(key)][col(key)] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return table[row(key)][col(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 
 
 class MyHashSet4 { // 112 ms

    private boolean[][] table = new boolean[1000][];
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    private int row (int key) {
        return key % 1000;
    }
    
    private int col (int key) {
        return key / 1000;
    }
    
    public void add(int key) {
        if (table[row(key)] == null) {
            table[row(key)] = new boolean[1000];
        }
        table[row(key)][col(key)] = true;
    }
    
    public void remove(int key) {
        if (table[row(key)] != null) {
            table[row(key)][col(key)] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return table[row(key)] != null && table[row(key)][col(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 
