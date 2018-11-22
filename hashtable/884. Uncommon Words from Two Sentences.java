// https://leetcode.com/problems/uncommon-words-from-two-sentences/
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] aWords = A.split(" ");
        String[] bWords = B.split(" ");
        List<String> resList = new ArrayList();
        
        Map<String, Integer> map = new HashMap();
        
        for (String w : aWords) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        for (String w : bWords) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                resList.add(e.getKey());
            }
        }
        
        String [] res = new String[resList.size()];
        
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        
        return res;
    }
}
