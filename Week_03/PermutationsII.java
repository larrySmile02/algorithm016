package com.yue.lib_javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {

    //全排列II :带有重复数组的全排列

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null||nums.length==0)return res;
        LinkedList<Integer> tmp=new LinkedList<>();
        boolean[]used= new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,used,tmp);
        return res;
    }

    public void dfs(int[]nums , boolean[]used, LinkedList<Integer> tmp){
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
}
