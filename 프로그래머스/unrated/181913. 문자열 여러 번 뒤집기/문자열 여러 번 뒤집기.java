class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for(int i=0; i<queries.length; i++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(sb.substring(queries[i][0], queries[i][1] + 1)).reverse();
            sb.replace(queries[i][0], queries[i][1] + 1, sb2.toString());
        }
        return sb.toString();
    }
}