package com.yue.lib_javatest;

public class Valid_anagram {

    public boolean isAnagram(String s, String t) {
        if(s==null && t==null)return true;
        if(s==null||t==null||s.length() != t.length()) return false;
        int[]s1=new int[26];
        int[]t1=new int[26];
        for(char c:s.toCharArray()){
            s1[c-'a']++;
        }
        for(char c:t.toCharArray()){
            t1[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(s1[i] != t1[i]) return false;
        }
        return true;
    }
}
