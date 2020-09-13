package com.yue.lib_javatest;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        for(int i=len-1;i>=0;i--){
            digits[i]++;
            if(digits[i]%10 !=0)return digits;
            else digits[i]=0;

        }
        int[]res=new int[len+1];
        res[0]=1;
        return res;
    }
}
