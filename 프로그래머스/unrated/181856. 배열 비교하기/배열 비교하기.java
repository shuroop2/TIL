import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length)
            return arr1.length > arr2.length ? 1 : arr1.length == arr2.length ? 0 : -1;
        else
            return Arrays.stream(arr1).sum() > Arrays.stream(arr2).sum() ? 1 : Arrays.stream(arr1).sum() == Arrays.stream(arr2).sum() ? 0 : -1;
    }
}