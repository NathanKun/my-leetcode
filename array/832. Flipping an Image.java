class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        for (int col = 0; col < A.length; col++) {
        
            final int[] row = A[col];
            final int rowLen = row.length;
            
            int[] newRow = new int[rowLen];
            
            // reverse
            for (int i = 0; i < rowLen; i++) {
                newRow[i] = row[rowLen - i - 1];
            }
            
            // flip
            for (int i = 0; i < rowLen; i++) {
                newRow[i] = newRow[i] == 0 ? 1 : 0;
            }
            
            A[col] = newRow;
        }
        
        return A;
    }
}
