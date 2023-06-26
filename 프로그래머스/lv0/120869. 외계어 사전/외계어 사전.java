class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean flag = false;
        for(int i=0; i<dic.length; i++) {
            int cnt = 0;
            for(int j=0; j<spell.length; j++)
                if(dic[i].contains(spell[j]))
                    cnt++;
            if(cnt == spell.length)
                flag = true;
        }
        return flag ? 1 : 2;
    }
}