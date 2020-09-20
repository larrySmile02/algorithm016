package com.yue.lib_javatest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==k) return nums;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] freqs=new List[nums.length+1];
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int freq=entry.getValue();
            int key=entry.getKey();
            if(freqs[freq]==null) freqs[freq]=new ArrayList<>();
            freqs[freq].add(key);

        }
        List<Integer>res=new ArrayList<>();
        for(int j=freqs.length-1;j>=0 ;j--){
            if(freqs[j]==null) continue;
            res.addAll(freqs[j]);

        }
        int[] result=new int[k];
        for(int m=0;m<res.size() && m<k;m++){
            result[m]=res.get(m);
        }
        return result;

    }
}
