class Solution {
    public int solution(String my_string) {
        if(!my_string.matches(".*[0-9].*"))
            return 0;
        int answer = 0;
        String[] tmp = my_string.replaceAll("\\D", " ").replaceAll("\\s+", " ").trim().split(" ");
        for(int i=0; i<tmp.length; i++)
            answer += Integer.parseInt(tmp[i]);
        return answer;
    }
}