class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<answer.length; i++)
            answer[i] = findBit(numbers[i]);
        
        return answer;
    }
    
    public long findBit(long n) {
        String tmp = String.format("%32s", Long.toBinaryString(n)).replaceAll(" ", "0");
        StringBuilder sb = new StringBuilder(tmp);
        
        for(int i=tmp.length()-1; i>=0; i--) {
            if(tmp.charAt(i) == '0') {
                if(i == tmp.length()-1)
                    return n+1;
                else {
                    sb.replace(i, i+2, "10");
                    break;
                }
            }
        }
        
        return Long.parseLong(sb.toString(), 2);
    }
}