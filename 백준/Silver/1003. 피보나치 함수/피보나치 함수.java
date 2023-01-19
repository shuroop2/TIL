import java.util.Scanner;
 
public class Main {
    static int[][] dp = new int[41][2];
    
    public static void main(String[] args) {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int[] tmp = solution(sc.nextInt());
			System.out.println(tmp[0] + " " + tmp[1]);
		}
		sc.close();
 
	}
	public static int[] solution(int num) {
        for(int i=2; i<=num; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
        
		return dp[num];
	}
}