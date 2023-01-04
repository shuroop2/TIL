class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int tmp = 1;
        
        while(tmp <= n) {
            if(idx < stations.length && tmp >= stations[idx] - w) {
                tmp = stations[idx] + w + 1;
                idx++;
            } else {
                tmp += 2 * w + 1;
                answer++;
            }
        }

        return answer;
    }
}