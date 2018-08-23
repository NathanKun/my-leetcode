// https://leetcode.com/problems/image-overlap/
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        
        final int len = A.length;
        
        List<Integer> ptA = new ArrayList();
        List<Integer> ptB = new ArrayList();
        
        // Loop throught A and B using a single index i [0, len * len - 1]
        // row => i / len, col => i % len
        
        // N is smaller than 30, so we could represent the index of a point in A and B like
        // 100 * r + c, EX: A[13][21] => 1321
        // and we save all points with value 1 in the arraylist
        
        for (int i = 0; i < len * len; i++) {
            final int r = i / len, c = i % len;
            if (A[r][c] == 1) {
                ptA.add(r * 100 + c); // must divide by len first, multiple by 100 after
            }
            
            if (B[r][c] == 1) {
                ptB.add(r * 100 + c);
            }
        }
        
        // map<slide_step, points_overlapped>
        // map of points overlapped count for every distances possible between points of A and B
        // EX: {5, 7} means if map A slide 5 times (don't care which direction), A and B will have 7 points overllapped
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        
        // so we check the distance between each pair (ptA, ptB)
        // and count for every distances possible, how many points overllapped
        for (int a : ptA) {
            for (int b : ptB) {
                final int count = map.getOrDefault(a - b, 0) + 1;
                map.put(a - b, count);
            }
        }
        
        // and find the max to return
        for (int count : map.values()) {
            if (count > max) {
                max = count;
            }
        }
        
        return max;
    }
}
