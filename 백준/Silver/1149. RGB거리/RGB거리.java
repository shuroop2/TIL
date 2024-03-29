import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][3];
		
		for(int i=1; i<=n; i++) {
			String[] arr = br.readLine().split(" ");
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + Integer.parseInt(arr[0]);
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + Integer.parseInt(arr[1]);
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(arr[2]);
		}
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
		
		br.close();
	}
}