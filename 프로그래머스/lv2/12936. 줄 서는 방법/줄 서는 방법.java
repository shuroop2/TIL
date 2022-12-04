import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long tmp = 1;
        int idx = 0;
        
        for(int i=1; i<=n; i++) {
            tmp *= i;
            list.add(i);
        }
        k--;
        
        while(idx < n) {
            tmp /= n - idx;
            answer[idx++] = list.remove((int) (k / tmp));;
            k %= tmp;
        }
        
        return answer;
    }
}