package com.yue.lib_javatest;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    //组合
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n==0 || k==0) return res;
        subCombine(n,k,1,new ArrayList<Integer>());
        return res;

    }

    public void subCombine(int n, int k,int cur,List<Integer> tmp){
        if(tmp.size()==k){
            res.add(new ArrayList<Integer>(tmp));
            return ;
        }

        for(int i=cur;i<=n && cur<=(n-k+1)+tmp.size();i++){
            tmp.add(i);
            subCombine(n,k,i+1,tmp);
            tmp.remove(tmp.size()-1);
        }

    }
}
