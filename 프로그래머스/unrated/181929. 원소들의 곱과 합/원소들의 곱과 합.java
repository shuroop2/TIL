class Solution {
    public int solution(int[] num_list) {
        int[] answer = {0, 1};
        for(int i=0; i<num_list.length; i++) {
            answer[0] += num_list[i];
            answer[1] *= num_list[i];
        }
        return (int) Math.pow(answer[0], 2) > answer[1] ? 1 : 0;
    }
}