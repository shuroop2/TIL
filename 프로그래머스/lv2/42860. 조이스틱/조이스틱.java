class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        
        for(int i=0; i<name.length(); i++) {
            if(name.charAt(i) <= 'N')
                answer += name.charAt(i) - 'A';
            else
                answer += 'Z' - name.charAt(i) + 1;
            
            int j = i + 1;
            while(j < name.length() && name.charAt(j) == 'A')
                j++;
            
            move = Math.min(move, i * 2 + name.length() - j);
            move = Math.min(move, i + 2 * (name.length() - j));
        }
        
        return answer + move;
    }
}