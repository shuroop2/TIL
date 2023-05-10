class Solution {
    public int solution(String myString, String pat) {
        return myString.replaceAll("A", "b").replaceAll("B", "A").replaceAll("b", "B").contains(pat) ? 1 : 0;
    }
}