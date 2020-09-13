package com.yue.lib_javatest;

import java.util.Stack;

public class MergeTwoArrays {
    //合并2个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2==null||nums2.length==0) return ;
        Stack<Integer> stack=new Stack<>();
        int i=0,j=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                stack.push(nums1[i]);
                i++;
            }else{
                stack.push(nums2[j]);
                j++;
            }

        }
        while(i<m){
            stack.push(nums1[i++]);
        }
        while(j<n){
            stack.push(nums2[j++]);
        }

        for(int k=m+n-1;k>=0;k--){
            nums1[k]=stack.pop();
        }

    }
}
