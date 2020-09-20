package com.yue.lib_javatest;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        if(strs==null||strs.length==0)return res;
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            String code=generate(s);
            List<String> list=map.get(code);
            if(list==null) {
                list=new ArrayList<>();
                list.add(s);
                map.put(code,list);
            }else{
                list.add(s);
            }
        }

        if(map.size() >0){
            for(Map.Entry<String,List<String>> entry: map.entrySet()){
                List<String> list=entry.getValue();
                if(list !=null && list.size()>0){
                    res.add(list);
                }
            }
        }

        return res;
    }

    public String generate(String s){
        if(s.length()==0)return s;
        int[]alph=new int[26];
        StringBuilder builder=new StringBuilder();
        for(char c:s.toCharArray()){
            alph[c-'a']++;
        }
        for(int i=0;i<26;i++){
            builder.append(alph[i]+(i+'a'));
        }
        return builder.toString();
    }
}
