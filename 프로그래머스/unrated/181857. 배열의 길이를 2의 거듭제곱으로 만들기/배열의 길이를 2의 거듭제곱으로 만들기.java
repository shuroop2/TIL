class Solution {
    public int[] solution(int[] arr) {
        int l = 0;
        for(int i=0; i<11; i++) {
            if(arr.length <= Math.pow(2, i)) {
                l = (int) Math.pow(2, i);
                break;
            }
        }
        int[] answer = new int[l];
        for(int i=0; i<arr.length; i++)
            answer[i] = arr[i];
        return answer;
    }
}