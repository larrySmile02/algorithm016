### 深度优先搜索和广度优先搜索
1. 深度优先搜索表现形式为递归遍历，在遍历二叉树一般情况下时间复杂度为O(logn)，空间复杂度为O(n).
2. 广度优先搜索变形形式为自己维护一个栈以及元素进栈和出栈。

### 贪心算法
还没有特别掌握好。有大神说“一般能用贪心算法的题目都能用动态规划解决”，个人倾向于用动态规划解决。

### 代表题目
1. [买卖股票最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/). 不确定是否严格的贪心算法解决
```
  public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) return 0;
        int prf=0,res=0;
        for(int i=1;i<prices.length;i++){
            prf=prices[i]-prices[i-1];
            if(prf>0) res+=prf;
        }
        return res;
    }
```
2. [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)。递归解决矩阵问题
```
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
 ```

