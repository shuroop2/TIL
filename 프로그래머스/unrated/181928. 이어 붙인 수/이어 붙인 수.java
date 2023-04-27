class Solution {
    public int solution(int[] num_list) {
        String[] answer = {"", ""};
        for(int i=0; i<num_list.length; i++)
            answer[num_list[i] % 2] += String.valueOf(num_list[i]);
        return Integer.parseInt(answer[0]) + Integer.parseInt(answer[1]);
    }
}