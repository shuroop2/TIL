import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        Arrays.sort(dots, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });
        return (dots[2][0] - dots[1][0]) * (dots[1][1] - dots[0][1]);
    }
}