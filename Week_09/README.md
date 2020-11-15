### 状态转换机
[leetcode8](https://leetcode-cn.com/problems/string-to-integer-atoi/) 字符串转换为整数，用到了“状态转换机”解法。

### 字符串动态规划
1. [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)在总结状态转移方程的时候要注意一个小陷阱: 字符串可能有重复。所以在s1[i-1]==s2[j-1]时不能推导出dp[i][j]=1+max(dp[i-1][j],dp[i][j-1]);而是将dp向前推了一步dp[i][j]=dp[i-1][j-1];
2. [编辑距离](https://leetcode-cn.com/problems/edit-distance/)和上一题状态转移方程有共同之处。当s1[i-1] != s2[j-1]时，编辑距离dp[i][j]=1+dp[i-1][j-1],这里容易出错。 
