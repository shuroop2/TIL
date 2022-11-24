import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0].toLowerCase();
            String head2 = o2.split("[0-9]")[0].toLowerCase();
            
            if(head1.compareTo(head2) == 0) {
                String numTail1 = o1.substring(head1.length());
                String numTail2 = o2.substring(head2.length());
                return compareNum(numTail1) - compareNum(numTail2);
            } else {
                return head1.compareTo(head2);
            }
        });
        return files;
    }
    
    private int compareNum(String numTail) {
        String result = "";
        
        for(char c : numTail.toCharArray()) {
            if(Character.isDigit(c) && result.length() < 5)
                result += c;
            else
                break;
        }

        return Integer.parseInt(result);
    }
}