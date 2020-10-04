package com.yue.lib_javatest;

public class LemonadeChange {
    //柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        if(bills.length==0) return true;
        int five=0,ten=0;
        for(int i:bills){
            if(i==5) five++;
            else if(i==10){
                five--;
                ten++;
            }else {
                if(ten>0){
                    ten--;
                    five--;
                }else{
                    five-=3;
                }
            }

            if(five<0) return false;
        }
        return true;
    }
}
