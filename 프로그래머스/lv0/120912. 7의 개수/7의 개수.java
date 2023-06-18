class Solution {
    public int solution(int[] array) {
        int cnt = 0;
        for(int i=0; i<array.length; i++) {
            while(array[i] > 0) {
                if(array[i] % 10 == 7)
                    cnt++;
                array[i] /= 10;
            }
        }
        return cnt;
    }
}