class Solution {
    public int solution(int num, int k) {
        if(String.valueOf(num).contains(String.valueOf(k))) {
            return String.valueOf(num).indexOf(String.valueOf(k)) + 1;
        }
        return -1;
    }
}