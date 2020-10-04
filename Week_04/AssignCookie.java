package com.yue.lib_javatest;

public class AssignCookie {


    //分发饼干
    public int findContentChildren(int[] g, int[] s) {
        if(g==null||s==null||g.length==0||s.length==0)return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0;
        int gp=0;
        int sp=0;
        while(gp<g.length && sp<s.length){
            if(g[gp]<=s[sp]){
                res++;
                gp++;
                sp++;
            }else {
                sp++;
            }
        }
        return res;
    }
}
