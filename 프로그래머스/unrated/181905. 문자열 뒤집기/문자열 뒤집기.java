class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(my_string.substring(s, e + 1)).reverse();
        return sb.replace(s, e + 1, sb2.toString()).toString();
    }
}