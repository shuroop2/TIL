class Solution {
    public long solution(String numbers) {
        String[] tmp = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<tmp.length; i++)
            numbers = numbers.replace(tmp[i], String.valueOf(i));
        return Long.parseLong(numbers);
    }
}