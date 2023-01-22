import java.util.Scanner;

public class Main {
	static int[][] dp = new int[31][31];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			sb.append(comb(M, N) + "\n");
		}
		
		System.out.println(sb);
		
		sc.close();
	}
	
	public static int comb(int n, int r) {
		if(dp[n][r] > 0)
			return dp[n][r];
		else if(n == r || r == 0)
			return dp[n][r] = 1;
		else
			return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
	}
}