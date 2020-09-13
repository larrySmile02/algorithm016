package com.yue.lib_javatest;

public class RemoveDuplicate {
    //删除数组中重复项
    public int removeDuplicates(int[] nums) {
        if(nums==null) return 0;
        if(nums.length<=1) return nums.length;

        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
