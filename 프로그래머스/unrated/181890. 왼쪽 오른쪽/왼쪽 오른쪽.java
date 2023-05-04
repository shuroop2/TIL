import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer;
        int idxL = Arrays.asList(str_list).indexOf("l") >= 0 ? Arrays.asList(str_list).indexOf("l") : 999;
        int idxR = Arrays.asList(str_list).indexOf("r") >= 0 ? Arrays.asList(str_list).indexOf("r") : 999;
        if(idxL < idxR) {
            answer = new String[idxL];
            for(int i=0; i<idxL; i++)
                answer[i] = str_list[i];
        } else if(idxL > idxR) {
            answer = new String[str_list.length - idxR - 1];
            System.out.println(idxR + " " + str_list.length);
            for(int i=idxR+1, j=0; i<str_list.length; i++)
                answer[j++] = str_list[i];
        } else {
            return new String[]{};
        }
        return answer;
    }
}