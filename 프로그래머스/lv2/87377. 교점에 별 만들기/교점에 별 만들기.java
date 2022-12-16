import java.util.*;

class Solution {
    static long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
    static long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
    
    public String[] solution(int[][] line) {
        List<long[]> list = new ArrayList<>();
        long x, y;
        for(int i=0; i<line.length; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for(int j=i+1; j<line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                long adbc = a * d - b * c;
                if(adbc == 0)
                    continue;
                
                long bfed = b * f - e * d;
                if(bfed % adbc != 0)
                    continue;
                
                long ecaf = e * c - a * f;
                if(ecaf % adbc != 0)
                    continue;
                
                x = bfed / adbc;
                y = ecaf / adbc;
                list.add(new long[]{x, y});
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }
        
        boolean[][] tmp = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        String[] answer = new String[tmp.length];
        
        for(long[] l : list) {
            int tmpX = (int) (l[0] - minX);
            int tmpY = (int) (l[1] - maxY);
            tmp[Math.abs(tmpY)][Math.abs(tmpX)] = true;
        }
        
        int i = 0;
        for(boolean[] bArr : tmp) {
            StringBuilder sb = new StringBuilder();
            for(boolean b : bArr) {
                if(b)
                    sb.append("*");
                else
                    sb.append(".");
            }
            answer[i++] = sb.toString();
        }
        
        return answer;
    }
}