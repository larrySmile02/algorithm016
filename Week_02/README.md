### 学习体会
渐渐习惯了“刻意练习”，学习效果比之前的方式要好很多。现在不仅仅是在学习算法中使用刻意练习，学习其他知识也是在“刻意练习”，感觉受益匪浅。有时候学习新的知识会花费很长时间去研究，比如学习堆排序的时候花了2个小时去debug，观察每一步怎么排序，不知道有没有更加高效的方式？
### HashMap总结
1. 没有hash碰撞情况下，put /get操作平均时间复杂度O(1)。
  - put操作会将计算出key 的hashcode, 然后key 、hashcode 、value一起创建成一个HashMap$Node对象，存入HashCode内部数组table中（其中HashMap$Node implements Map.Entry）。
  - get操作会计算出key的hashcode -> 根据hashcode计算出对应的value在table的下标 -> 根据下标获取value。
2. hash碰撞的情况下，put/get操作平均时间复杂度可能达到O(n)。
  - hash碰撞的原因：不同的key计算出相同的hashcode，导致不同的value要保存在table的同一个位置上。
  - hash碰撞的处理：HashMap$Node数组table中的元素生成链表或者红黑树。
### 排序的运用
1. [最小k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)的O(1)解法:使用快排。

```
public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null||arr.length==0||k==0)return new int[0];
        return quickSort(arr,0,arr.length-1,k-1);
    }

    public int[] quickSort(int[]nums , int start , int end,int k){
        int j=partNums(nums,start,end);
        if(j==k) return Arrays.copyOf(nums,k+1);
        else if(j<k) return quickSort(nums,j+1,end,k);
        else return quickSort(nums,start,j-1,k);
    }

    public int partNums(int[]nums , int start  , int end){
        int p=nums[start];
        int i=start;
        int j=end;
        while(i<j){
            while(i<j && nums[j]>=p)j--;
            while(i<j && nums[i]<=p)i++;
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        nums[start]=nums[j];
        nums[j]=p;
        return j;
    }
```
### HashMap和排序的结合
1. [前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/):先使用HashMap统计频率，再用数组保存高频元素的List。
```
 public int[] topKFrequent(int[] nums, int k) {
        if(nums==null||nums.length<=k) return nums;
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] freqs=new List[nums.length+1];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val=entry.getValue();
            int key=entry.getKey();
            List<Integer> list= freqs[val];
            if(list==null){
                list=new ArrayList<>();
                list.add(key);
                freqs[val]=list;
            }else{
                list.add(key);
            }
        }
        
        List<Integer> res=new ArrayList<>();
        for(int j=freqs.length-1;j>=0;j--){
            if(freqs[j]==null) continue;
            else res.addAll(freqs[j]);
        }
        int[]result=new int[k];
        for(int m=0;m<k;m++){
            result[m]=res.get(m);
        }
        return result;

    }
```

