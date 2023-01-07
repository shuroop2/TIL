import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<privacies.length; i++) {
            for(int j=0; j<terms.length; j++) {
                if(privacies[i].split(" ")[1].equals(terms[j].split(" ")[0])) {
                    int year = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[0]);
                    int month = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[1]);
                    int day = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[2]);
                    int term = Integer.parseInt(terms[j].split(" ")[1]);
                    
                    if(month + term > 12) {
                        if((month + term) % 12 == 0) {
                            year += (month + term) / 12 - 1;
                            month = 12;
                        } else {
                            year += (month + term) / 12;
                            month = (month + term) % 12;
                        }
                    } else {
                        month += term;
                    }
                    System.out.println(year * 10000 + month * 100 + day);
                    if(year * 10000 + month * 100 + day <= Integer.parseInt(today.replace(".", ""))) {
                        list.add(i + 1);
                        break;
                    }
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}