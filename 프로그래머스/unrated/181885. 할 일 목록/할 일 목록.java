import java.util.Arrays;
import java.util.Collections;
import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int cnt = 0;
        for(boolean b : finished)
            if(!b)
                cnt++;
        
        String[] answer = new String[cnt];
        for(int i=0, j=0; i<todo_list.length; i++)
            if(!finished[i])
                answer[j++] = todo_list[i];
        return answer;
    }
}