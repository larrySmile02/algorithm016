package com.yue.lib_javatest;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrder {
    List<Integer> list=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)return list;
        LinkedList<TreeNode> nodes=new LinkedList<>();
        nodes.addLast(root);
        while(!nodes.isEmpty()){
            TreeNode cur= nodes.poll();
            if(cur.left==null && cur.right==null){
                list.add(cur.val);
            }else{
                TreeNode right=cur.right;
                TreeNode left=cur.left;
                if(right !=null){
                    nodes.addFirst(right);
                    cur.right=null;
                }
                nodes.addFirst(cur);
                if(left !=null){
                    nodes.addFirst(left);
                    cur.left=null;
                }
            }
        }
        return list;
    }
}
