package com.yue.lib_javatest;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length==0) return;
        int low=0,fast=0;
        while(fast<nums.length && low<=fast){
            if(nums[low]==0 && nums[fast] != 0){
                nums[low]=nums[fast];
                nums[fast]=0;
            }
            fast++;
            if(nums[low] !=0) low++;
        }
    }
}
