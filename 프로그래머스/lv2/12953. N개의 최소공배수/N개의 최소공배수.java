class Solution {
    public int solution(int[] arr) {
        int answer = lcm(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++) {
            answer = lcm(arr[i], answer);
        }
        return answer;
    }
    
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}