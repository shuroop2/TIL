import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
    static int max = -1;
    
    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        
        dfs(n, info, ryan, 0, 0);
        if(max == -1)
            return new int[]{-1};
        
        Collections.sort(list, (o1, o2) -> {
            for(int i=10; i>=0; i--) {
                if(o1[i] != o2[i])
                    return o2[i] - o1[i];
            }
            return 0;
        });
        
        return list.get(0);
    }
    
    public void dfs(int n, int[] info, int[] ryan, int depth, int start) {
        if(depth == n) {
            int sum1 = 0;
            int sum2 = 0;
            for(int i=0; i<10; i++) {
                if(info[i] != 0 || ryan[i] != 0) {
                    if(info[i] >= ryan[i])
                        sum1 += 10 - i;
                    else
                        sum2 += 10 - i;
                }
            }
            
            if(sum1 < sum2) {
                int dif = sum2 - sum1;
                if(max < dif) {
                    max = dif;
                    list.clear();
                    list.add(ryan.clone());
                } else if(max == dif) {
                    list.add(ryan.clone());
                }
            }
            return;
        }
        
        for(int i=start; i<11; i++) {
            ryan[i]++;
            dfs(n, info, ryan, depth + 1, i);
            ryan[i]--;
        }
    }
}