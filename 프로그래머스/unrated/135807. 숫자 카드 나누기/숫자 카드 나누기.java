import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(findNum(arrayA, arrayB), findNum(arrayB, arrayA));
    }
    
    public int findNum(int[] arr1, int[] arr2) {
        int result = 0;
        List<Integer> list = findDivisor(arr1);
        
        for(int i=0; i<list.size(); i++) {
            boolean flag = true;
            for(int j=0; j<arr1.length; j++) {
                if(arr1[j] % list.get(i) != 0 || arr2[j] % list.get(i) == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                result = Math.max(result, list.get(i));
        }

        return result;
    }
    
    public List<Integer> findDivisor(int[] arr) {
        Arrays.sort(arr);
        int min = arr[0];
        List<Integer> list = new ArrayList<>();
        
        for(int i=2; i<=min; i++) {
            if(min % i == 0)
                list.add(i);
        }
        
        return list;
    }
}