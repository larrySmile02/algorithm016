package com.yue.lib_javatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrder {
    List<Integer> res=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur=stack.pop();
            TreeNode left=cur.left;
            TreeNode right=cur.right;
            if(left==null && right==null){
                res.add(cur.val);
                continue;
            }
            if(right !=null) {
                stack.push(right);
                cur.right=null;
            }
            if(left !=null){
                stack.push(left);
                cur.left=null;
            }
            stack.push(cur);

        }
        return res;
    }
}
