package com.yue.lib_javatest;

public class BuyStock {
    //买卖股票最佳时机
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) return 0;
        int prf=0,res=0;
        for(int i=1;i<prices.length;i++){
            prf=prices[i]-prices[i-1];
            if(prf>0) res+=prf;
        }
        return res;
    }
}
