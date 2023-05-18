import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++)
            for(int j=0; j<arr.length; j++)
                if(intervals[i][0] <= j && j <= intervals[i][1])
                    list.add(arr[j]);
        return list.stream().mapToInt(i -> i).toArray();
    }
}