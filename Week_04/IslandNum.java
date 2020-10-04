package com.yue.lib_javatest;

public class IslandNum {

    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int res=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]=='1'){
                    res++;
                    dfs(grid,r,c);
                }
            }
        }
        return res;

    }

    public void dfs(char[][]grid ,int r, int c){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length ||grid[r][c]=='0') return;
        grid[r][c]='0';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}
