import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String a = sc.next();
        for(int i=0; i<a.length(); i++) {
            if(64 < a.charAt(i) && a.charAt(i) < 91)
                sb.append((char) (a.charAt(i) + 32));
            else
                sb.append((char) (a.charAt(i) - 32));
        }
        System.out.println(sb);
    }
}