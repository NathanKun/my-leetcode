// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
class Solution1 { / 195 ms
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap();
        
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    map.put(list1[i], i + j);
                }
            }
        }
        
        int min = 10000;
        int count = 0;
        
        for (int v : map.values()) {
            if (v < min) {
                min = v;
                count = 1;
            } else if (v == min) {
                count++;
            }
        }
        System.out.println("count = " + count);
        System.out.println("min = " + min);
        
        String[] res = new String[count];
        count = 0;
        
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == min) {
                res[count] = e.getKey();
                count++;
            }
        }
        
        return res;
    }
}

class Solution2 { // 27 ms
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap();
        int count = 0;
        
        for (String s : list1) {
            map.put(s, count);
            count++;
        }
        
        count = 0;
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList();
        
        for (String s : list2) {
            Integer v = map.get(s);
            
            if (v != null && min >= v + count) {
                if (min > v + count) {
                    res.clear();
                    min = v + count;
                }
                res.add(s);
            }
            
            count++;
        }
        
        return res.toArray(new String[0]);
    }
}
