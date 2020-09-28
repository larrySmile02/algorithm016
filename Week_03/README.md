### 学习总结
1. 初步掌握递归。可以做出来一些二叉树相关的递归题，但是没有达到灵活使用的水平。
2. 初步认识回溯算法。可以写出子集、全排列的回溯题，但是没见过的题不会做！

### 回溯法

目前使用于子集于全排列。模板：

```
result
fun backtrace(选择列表，临时列表tmp){
    if 满足条件
    result.add(临时列表tmp);
    return;
    
    for 选择in选择列表
    做选择（tmp.add(选择)）
    backtrace(...);
    撤销选择(tmp.remove(选择))
    
}
```

#### 子集
1. [无重复元素数组子集](https://leetcode-cn.com/problems/subsets/)，就套模板.
 
根据官方题解
- 时间复杂度：O(n*2^n
 )。一共 2^n个状态，每种状态需要 O(n)的时间来构造子集。
- 空间复杂度：O(n)。即构造子集使用的临时数组 tmp的空间代价。


```
 public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null) return res;
        List<Integer> tmp=new ArrayList<>();
        backtrace(0,nums,res,tmp);
        return res;
    }

    public void backtrace(int start,int[] nums, List<List<Integer>> res, List<Integer> tmp){
        res.add(new ArrayList<>(tmp));
        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            backtrace(i+1,nums,res,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
```
2. [有重复元素的子集](https://leetcode-cn.com/problems/subsets/solution/hui-su-si-xiang-tuan-mie-pai-lie-zu-he-zi-ji-wen-t/)，比起无重复元素子集多了2个动作：数组排序和跳过重复元素

```
List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null||nums.length==0)return res;
        Arrays.sort(nums); //数组排序
        return backtrace(nums,0,new ArrayList<Integer>());
        
    }

    public List<List<Integer>> backtrace(int[]nums ,int index, List<Integer> tmp){
        res.add(new ArrayList<Integer>(tmp));
        for(int i=index;i<nums.length;i++){
        //跳过重复元素
            if(i>index &&nums[i]==nums[i-1])
            continue;
            else tmp.add(nums[i]);
            backtrace(nums,i+1,tmp);
           tmp.remove(tmp.size()-1);
        }
        return res;
        
    }
```
#### 全排列
1. [无重复数字的全排列](https://leetcode-cn.com/problems/permutations/)，直接套回溯法模板。==至于为何使用回溯法我还没有深入分析==。[这位作者](https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/)用决策树做了详细分析，==后续有时间需要研究一下==。

```
List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length==0)return res;
        LinkedList<Integer> tmp=new LinkedList<>();
        dfs(nums,tmp);
        return res;

    }

    public void dfs(int[]nums ,LinkedList<Integer> tmp){
        if(tmp.size()==nums.length) {
            res.add(new LinkedList<Integer>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(tmp.contains(nums[i])) continue;
            tmp.addLast(nums[i]);
            dfs(nums,tmp);
            tmp.removeLast();
        }
    }
```
2. [有重复数字的全排列](https://leetcode-cn.com/problems/permutations-ii/)，要看懂代码需要先看懂[这位作者](https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/)决策树种的剪枝过程。==有时间需要研究一下==。

根据官方题解
- 时间复杂度：O(n×n!)，其中 n为序列的长度。backtrack 的调用次数是 O(n!)的，共有n个节点调用了backtrace。
- 空间复杂度：O(n)。

```
List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null||nums.length==0)return res;
        LinkedList<Integer> tmp=new LinkedList<>();
        boolean[]used= new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,used,tmp);
        return res;
    }

    public void dfs(int[]nums ,boolean[]used,LinkedList<Integer> tmp){
       if(tmp.size()==nums.length){
           res.add(new LinkedList<Integer>(tmp));
           return;
       }
       for(int i=0;i<nums.length;i++){
           if(used[i]) continue;
           if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
           tmp.addLast(nums[i]);
           used[i]=true;
           dfs(nums,used,tmp);
           tmp.removeLast();
           used[i]=false;
       }
    }
```


#### 组合
[组合](https://leetcode-cn.com/problems/combinations/)适用于回溯法，同时分析一下过程可以进行剪枝优化。题解：

```
List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n==0 || k==0) return res;
        subCombine(n,k,1,new ArrayList<Integer>());
        return res;

    }

    public void subCombine(int n, int k,int cur,List<Integer> tmp){
        if(tmp.size()==k){
            res.add(new ArrayList<Integer>(tmp));
            return ;
        }

        for(int i=cur;i<=n && cur<=(n-k+1)+tmp.size();i++){
            tmp.add(i);
            subCombine(n,k,i+1,tmp);
            tmp.remove(tmp.size()-1);
        }

    }
```
分析决策树，学习剪枝优化

![image](https://github.com/larrySmile02/algorithm016/blob/master/Week_03/image/%E5%86%B3%E7%AD%96%E6%A0%91.jpg)

