package com.yue.lib_javatest;

public class BuildTrees {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0) return null;
        LinkedList<TreeNode> roots=new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        roots.addLast(root);
        int inIndex=0;
        for(int i=1;i<preorder.length;i++){
            TreeNode node=roots.peekLast();
            if(node.val !=inorder[inIndex]){
                node.left=new TreeNode(preorder[i]);
                roots.addLast(node.left);
            }else{
                TreeNode lastRoot=null;
                while( !roots.isEmpty() && roots.peekLast().val == inorder[inIndex]){
                    lastRoot=roots.removeLast();
                    inIndex++;
                }
                lastRoot.right=new TreeNode(preorder[i]);
                roots.addLast(lastRoot.right);
            }
        }
        return root;
    }
}
