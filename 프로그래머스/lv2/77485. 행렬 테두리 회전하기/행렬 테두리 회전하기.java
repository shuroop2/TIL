class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int cnt = 1;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++)
                arr[i][j] = cnt++;
        }
        
        for(int i=0; i<queries.length; i++) {
            answer[i] = spin(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1, arr);
        }
        
        return answer;
    }
    
    public int spin(int x1, int y1, int x2, int y2, int[][] arr) {
        int min = arr[x1][y1];
        int tmp = min;
        
        for(int i=x1; i<x2; i++) {
            arr[i][y1] = arr[i + 1][y1];
            if(arr[i][y1] < min)
                min = arr[i][y1];
        }  
        for(int i=y1; i<y2; i++) {
            arr[x2][i] = arr[x2][i + 1];
            if(arr[x2][i] < min)
                min = arr[x2][i];
        }
        for(int i=x2; i>x1; i--) {
            arr[i][y2] = arr[i - 1][y2];
            if(arr[i][y2] < min)
                min = arr[i][y2];
        }
        for(int i=y2; i>y1; i--) {
            arr[x1][i] = arr[x1][i - 1];
            if(arr[x1][i] < min)
                min = arr[x1][i];
        }
        arr[x1][y1 + 1] = tmp;
        
        return min;
    }
}