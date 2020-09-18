
### 如何高效学习
![image](https://github.com/larrySmile02/algorithm016/blob/master/Week_01/image/%E5%A6%82%E4%BD%95%E9%AB%98%E6%95%88%E5%AD%A6%E4%B9%A0%E7%AE%97%E6%B3%95.png)

### 面试时如何优秀的回答
比如[柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/) 这题共有2中解法，第一种暴力求解，时间复杂度是O(n^2)空间复杂度是O(n);第二种是单调栈，时间复杂度O(n)空间复杂度O(n)

### 数组
![image](https://github.com/larrySmile02/algorithm016/blob/master/Week_01/image/%E6%95%B0%E7%BB%84.png)

### 栈
- 先进后出
- push 、pop操作时间复杂度O(1)
- search操作时间复杂度O(n)
- pop、search操作被sychronized修饰，是线程安全操作
### Queue、Deque
- Queue先进先出，Deque有可以满足先进先出也可以满足先进后出。
- Deque是接口，常用的实现类有LinkedList,底层实现原理是双向链表。
### 单调栈代表题
[滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/) 

```
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0||k==1) return nums;
        SpecialStack stack=new SpecialStack();
        int[]res=new int[nums.length-k+1];
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(i<k-1){
                stack.push(nums[i]);
            }else{
                stack.push(nums[i]);
                res[index]=stack.max();
                stack.pop(nums[i-k+1]);
                index++;
            }
        }
        return res;
        
    }
    //典型的单调栈
    class SpecialStack {
        LinkedList<Integer> linkedList=new LinkedList<>();
        
        public void push(int i){
            while(!linkedList.isEmpty() && linkedList.peekLast()<i){
                linkedList.removeLast();
            }
            linkedList.addLast(i);
        }

        public void pop(int i){
            if(linkedList.peekFirst()==i) linkedList.removeFirst();

        }

        public int max(){
            return linkedList.peekFirst();
        }
    }
}
```
