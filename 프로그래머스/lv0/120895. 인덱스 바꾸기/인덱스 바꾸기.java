class Solution {
    public String solution(String my_string, int num1, int num2) {
        char tmp1 = my_string.charAt(num1);
        char tmp2 = my_string.charAt(num2);
        
        char[] chars = my_string.toCharArray();
        chars[num1] = tmp2;
        chars[num2] = tmp1;
        
        return String.valueOf(chars);
    }
}