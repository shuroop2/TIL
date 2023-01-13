class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = 1, high = 200000000;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            
            if(check(stones, k, mid)) {
                low = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                high = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean check(int[] stones, int k, int mid) {
        int cnt = 0;
        
        for(int i=0; i<stones.length; i++) {
            if(stones[i] < mid)
                cnt++;
            else
                cnt = 0;
            
            if(cnt == k)
                return false;
        }
        
        return true;
    }
}