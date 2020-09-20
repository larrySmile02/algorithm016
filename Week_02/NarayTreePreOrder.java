package com.yue.lib_javatest;

import java.util.ArrayList;
import java.util.List;

public class NarayTreePreOrder {
    List<Integer> res=new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null)return res;
        res.add(root.val);
        List<Node> children=root.children;
        if(children !=null && children.size()>0){
            for(Node n:children){
                preorder(n);
            }
        }
        return res;
    }
}
