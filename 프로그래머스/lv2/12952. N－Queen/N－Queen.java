class Solution {
    static int answer = 0;
    static int[] arr;
    
    public int solution(int n) {
        arr = new int[n];
        nQueen(n, 0);
        
        return answer;
    }
    
    public void nQueen(int n, int depth) {
        if(depth == n) {
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++) {
            arr[depth] = i;
            if(check(depth))
                nQueen(n, depth + 1);
        }
    }
    
    public boolean check(int depth) {
        for(int i=0; i<depth; i++) {
            if(arr[depth] == arr[i])
                return false;
            else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i]))
                return false;
        }
        return true;
    }
}