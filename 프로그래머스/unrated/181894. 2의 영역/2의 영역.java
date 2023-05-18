import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n1 = list.indexOf(2), n2 = list.lastIndexOf(2);
        int[] answer;
        if(n1 == -1) {
            return new int[]{-1};
        } else if(n1 == n2) {
            return new int[]{2};
        } else {
            answer = new int[n2 - n1 + 1];
            for(int i=n1, j=0; i<=n2; i++)
                answer[j++] = arr[i];
        }
        return answer;
    }
}