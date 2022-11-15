import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int cnt = 0;
        
        for(int i=0; i<str1.length()-1; i++) {
            if(Pattern.matches("^[a-z]*$", str1.substring(i, i+2)))
                list1.add(str1.substring(i, i+2));
        }
        for(int i=0; i<str2.length()-1; i++) {
            if(Pattern.matches("^[a-z]*$", str2.substring(i, i+2)))
                list2.add(str2.substring(i, i+2));
        }
        int sum = list1.size() + list2.size();
        
        for(int i=0; i<list1.size(); i++) {
            for(int j=0; j<list2.size(); j++) {
                if(list1.get(i).equals(list2.get(j))) {
                    cnt++;
                    list2.remove(j);
                    break;
                }
            }
        }
        sum -= cnt;

        return sum == 0 ? 65536 : (int) 65536 * cnt / sum ;
    }
}