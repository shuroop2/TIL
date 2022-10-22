class Solution {
    public int solution(int n) {
        String tmp = new StringBuffer(Integer.toString(n, 3)).reverse().toString();
        int answer = Integer.parseInt(tmp, 3);
        return answer;
    }
}