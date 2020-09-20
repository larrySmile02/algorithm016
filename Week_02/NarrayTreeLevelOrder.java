package com.yue.lib_javatest;

public class NarrayTreeLevelOrder {

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null)return res;
        LinkedList<LinkedList<Node>> linkedlist=new LinkedList<>();
        LinkedList<Node> list=new LinkedList<>();
        list.add(root);
        linkedlist.add(list);
        while(!linkedlist.isEmpty()){
            LinkedList<Node> nodes= linkedlist.poll();
            LinkedList<Node> children=new LinkedList<>();
            List<Integer> result=new ArrayList<>();
            while(!nodes.isEmpty()){
                Node nd=nodes.poll();
                result.add(nd.val);
                if(nd.children !=null && nd.children.size()>0) children.addAll(nd.children);

            }
            res.add(result);
            if(children.size()>0)linkedlist.addLast(children);
        }

        return res;

    }
}
