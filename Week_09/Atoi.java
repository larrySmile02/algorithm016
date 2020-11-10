class Solution {
    public int myAtoi(String s) {
        if(s==null) return 0;
        Automation auto=new Automation();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            auto.count(c);
        }
        return (int)(auto.sign * auto.ans);
    }
}

class Automation{
    public int sign=1;
    public long ans=0;
    public String state="start";
    public Map<String,String[]> table=new HashMap<>(){
        {
            put("start",new String[]{"start","signed","num","end"});
            put("signed",new String[]{"end","end","num","end"});
            put("num",new String[]{"end","end","num","end"});
            put("end",new String[]{"end","end","end","end"});
        }
    };

    public void count(char c){
        state=table.get(state)[getCol(c)];
        if(state.equals("signed")){
            if(c=='+')sign=1;
            else sign=-1;
        }else if(state.equals("num")){
            ans=10*ans+(c-'0');
            ans=sign==1?Math.min(ans,Integer.MAX_VALUE):Math.min(ans,-(long)Integer.MIN_VALUE);
        }
    }

    private int getCol(char c){
        if(c==' '){
            return 0;
        }else if(c=='+'||c=='-'){
            return 1;
        }else if(Character.isDigit(c)){
            return 2;
        }
        return 3;
    }

}