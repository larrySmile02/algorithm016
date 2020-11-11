package com.mengyao.lib_test;


public class ReverseString {

    public String reverseStr(String s, int k) {
        if(s==null||s.length()<=1||k==1) return s;
        char[] s1= s.toCharArray();
        for(int start=0;start<s1.length;start+=2*k){
            int i=start,j=Math.min(start+k-1,s1.length-1);
            while (i<j){
                char tmp=s1[i];
                s1[i++]=s1[j];
                s1[j--]=tmp;
            }
        }
        return new String(s1);
    }



}
