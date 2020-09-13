package com.yue.lib_javatest;

import java.util.Stack;

public class TrappingRain {
    //接雨水
    public int trap(int[] height) {
        if(height==null||height.length<3) return 0;
        Stack<Integer>stack=new Stack<>();
        int res=0;
        for(int i=0;i<height.length;i++){
            while(!stack.empty() && height[i]> height[stack.peek()]){
                int h=height[stack.peek()];
                stack.pop();
                if(stack.empty()) continue;
                int w=i-stack.peek()-1;
                int y=Math.min(height[i],height[stack.peek()])-h;
                res+= w*y;

            }
            stack.push(i);
        }

        return res;
    }
}
