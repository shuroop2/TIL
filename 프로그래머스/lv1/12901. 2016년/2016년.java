class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0;
        for(int i=0; i<a-1; i++) {
            day += month[i];
        }
        day += b-1;
        day %= 7;
        answer = week[day];
        return answer;
    }
}