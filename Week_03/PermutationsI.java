package com.yue.lib_javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsI {

    //全排列I :不带重复数组的全排列

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
}
