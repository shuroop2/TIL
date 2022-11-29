class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int tmp = 0;
        
        for(int i=0; i<number.length()-k; i++) {
            int max = 0;
            
            for(int j=idx; j<=i+k; j++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    tmp = j;
                }
            }
            
            sb.append(max);
            idx = tmp + 1;
        }
        
        return sb.toString();
    }
}