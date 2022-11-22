import java.util.*;

class Solution {
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        int nowX = 0, nowY = 0;
        
        for(int i=0; i<dirs.length(); i++) {
            int nextX = nowX;
            int nextY = nowY;
            
            if(dirs.charAt(i) == 'U' && nowY < 5)
                nowY++;
            else if(dirs.charAt(i) == 'D' && nowY > -5)
                nowY--;
            else if(dirs.charAt(i) == 'R' && nowX < 5)
                nowX++;
            else if(dirs.charAt(i) == 'L' && nowX > -5) 
                nowX--;
            
            if(nextX == nowX && nextY == nowY)
                continue;
            
            set.add(nowX + "" + nowY + "" + nextX + "" + nextY + "");
            set.add(nextX + "" + nextY + "" + nowX + "" + nowY + "");
        }
        
        return set.size() / 2;
    }
}