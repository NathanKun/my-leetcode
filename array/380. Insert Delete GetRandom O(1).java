// https://leetcode.com/problems/insert-delete-getrandom-o1/
class RandomizedSet {
    
    private ArrayList<Integer> data;
    private Map<Integer, Integer> valIndexMap;
    private Random rnd;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valIndexMap = new HashMap();
        data = new ArrayList();
        rnd = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valIndexMap.containsKey(val)) {
            return false;
        }
        
        valIndexMap.put(val, data.size());
		data.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (valIndexMap.containsKey(val)) {
            int i = valIndexMap.get(val);
            valIndexMap.remove(val);
			int valLast = data.remove(data.size() - 1);
			
			// move last element to index of element to delete
			if (i != data.size()) {
				data.set(i, valLast);
				valIndexMap.put(valLast, i);
			}
            
            return true;
        }
        
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
		return data.get(rnd.nextInt(data.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 
