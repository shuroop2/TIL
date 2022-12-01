import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[] pri = {"+-*", "+*-", "*+-", "*-+", "-+*", "-*+"};
        ArrayList<Long> num = new ArrayList<>();
        ArrayList<Character> cal = new ArrayList<>();
        int idx = 0;
        
        for(int i=0; i<expression.length(); i++) {
            if(!Character.isDigit(expression.charAt(i))) {
                num.add(Long.parseLong(expression.substring(idx, i)));
                cal.add(expression.charAt(i));
                idx = i + 1;
            }
        }
        num.add(Long.parseLong(expression.substring(idx, expression.length())));
        
        for(String s : pri) {
            ArrayList<Long> tmpNum = new ArrayList<>(num);
            ArrayList<Character> tmpCal = new ArrayList<>(cal);

            for(char c : s.toCharArray()){ 
                for(int i=0; i<tmpCal.size();){
                    char op = tmpCal.get(i);
                    if(op != c) {
                        i++;
                        continue;
                    }
                    
                    if(op == '+')
                        tmpNum.set(i, tmpNum.get(i) + tmpNum.get(i + 1));    
                    else if(op == '-')
                        tmpNum.set(i, tmpNum.get(i) - tmpNum.get(i + 1));
                    else if(op == '*')
                        tmpNum.set(i, tmpNum.get(i) * tmpNum.get(i + 1));

                    tmpNum.remove(i + 1);
                    tmpCal.remove(i);
                }
            }
            answer = Math.max(answer, Math.abs(tmpNum.get(0)));
        }
        
        return answer;
    }
} 