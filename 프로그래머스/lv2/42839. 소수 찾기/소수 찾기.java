import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
        
    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        boolean[] visited = new boolean[numbers.length()];
                
        dfs(arr, visited, "", 0);
        
        return set.size();
    }
    
    public void dfs(char[] arr, boolean visited[], String str, int idx) {
        if(!str.equals("")) {
            int n = Integer.parseInt(str);
            if(isPrime(n))
                set.add(n);
        }
        
        if(idx == arr.length)
            return;
        
        for(int i=0; i<arr.length; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            dfs(arr, visited, str + arr[i], idx + 1);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int n) {
        if(n < 2)
            return false;
		
		for(int i=2; i*i<=n; i++) {
			if(n % i == 0)
                return false;
		}
		
		return true;
    }
}