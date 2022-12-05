class Solution {
    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcd(w, h));
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}