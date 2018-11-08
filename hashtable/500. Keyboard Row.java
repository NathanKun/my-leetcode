// https://leetcode.com/problems/keyboard-row/
class Solution {
    public String[] findWords(String[] words) {
        final Set<Character> row1 = Arrays.stream(new Character[] { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' }).collect(Collectors.toSet());
        final Set<Character> row2 = Arrays.stream(new Character[] { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' }).collect(Collectors.toSet());
        final Set<Character> row3 = Arrays.stream(new Character[] { 'z', 'x', 'c', 'v', 'b', 'n', 'm' }).collect(Collectors.toSet());
        
        
        final List<Set<Character>> rows = new ArrayList();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        
        List<String> resList = new ArrayList();
        
        for (String word : words) {            
            final char[] letters = word.toLowerCase().toCharArray();
            int iR;
            
            if (row1.contains(letters[0])) {
                iR = 0;
            } else if (row2.contains(letters[0])) {
                iR = 1;
            } else if (row3.contains(letters[0])) {
                iR = 2;
            } else {
                iR = -1;
            }
            
            boolean ok = true;
            for (char c : letters) {
                if (!rows.get(iR).contains(c)) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) {
                resList.add(word);
            }
        }
        
        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        
        return res;
    }
}
