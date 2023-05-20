class Solution {
    public int[] solution(int[] arr, int n) {
        for(int i=0; i<arr.length; i++)
            if(i % 2 != arr.length % 2)
                arr[i] += n;
        return arr;
    }
}