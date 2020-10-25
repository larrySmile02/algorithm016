class MinPathSum {
    
    //最小路径和
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0||grid[0].length==0) return 0;
        int row=grid.length;
        int col=grid[0].length;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(r>0 && c>0){
                    grid[r][c]+=Math.min(grid[r-1][c],grid[r][c-1]);
                }else if(r==0 && c>0){
                    grid[r][c]+=grid[r][c-1];
                }else if(r>0 && c==0){
                    grid[r][c]+=grid[r-1][c];
                }
            }
        }
        return grid[row-1][col-1];
    }
}