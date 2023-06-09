class Solution {
    public int solution(int order) {
        int answer = 0;
        String tmp = String.valueOf(order);
        for(int i=0; i<tmp.length(); i++)
            if(tmp.charAt(i) == '3' || tmp.charAt(i) == '6' || tmp.charAt(i) == '9')
                answer++;
        return answer;
    }
}