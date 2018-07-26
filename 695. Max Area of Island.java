class Solution {
    private int rCount;
    private int cCount;
 		
    public int maxAreaOfIsland(int[][] grid) {
    	rCount = grid.length;
		cCount = grid[0].length;
        
        int max = 0;
        
        for (int r = 0; r < rCount; r++) {
            for (int c = 0; c < cCount; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, explore(r, c, grid));
                }
            }
        }
        
        return max;
    }
    
    private int explore(int r, int c, int[][] grid){
    	ArrayList<int[]> island = new ArrayList<int[]>();
    	island.add(new int[] {r, c, 0});
        grid[r][c] = 2;
    	
    	boolean finished = false;
    	while (!finished) {
    		finished = true;
    		
    		for (int i = 0; i < island.size(); i++) {
    			if (checkNearBy(grid, island, island.get(i))) {
    				finished = false;
    			}
    		}
    	}
    	
    	return island.size();
    }
    
    // return true if found 1 near by
    private boolean checkNearBy(int[][] grid, ArrayList<int[]> island, int[] cell) {
    	if (cell[2] == 1) {
    		return false;
    	}
    	
    	cell[2] = 1;
    	
    	final int r = cell[0];
    	final int c = cell[1];
    	boolean foundNew = false;
    	
    	if (r != 0) {
    		if (grid[r - 1][c] == 1) {
    			foundNew = true;
    			island.add(new int[] {r - 1, c, 0});
                grid[r - 1][c] = 2;
    		}
    	}
    	
    	if (c != 0) {
    		if (grid[r][c - 1] == 1) {
    			foundNew = true;
    			island.add(new int[] {r, c - 1, 0});
                grid[r][c - 1] = 2;
    		}
    	}
    	
    	if (r != rCount - 1) {
    		if (grid[r + 1][c] == 1) {
    			foundNew = true;
    			island.add(new int[] {r + 1, c, 0});
                grid[r + 1][c] = 2;
    		}
    	}
    	
    	if (c != cCount - 1) {
    		if (grid[r][c + 1] == 1) {
    			foundNew = true;
    			island.add(new int[] {r, c + 1, 0});
                grid[r][c + 1] = 2;
    		}
    	}
    	
    	return foundNew;
    }
}
