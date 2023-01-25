import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Math.min(n, m);
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++)
				arr[i][j] = tmp.charAt(j) - '0';
		}
		
		while(l > 1) {
			for(int i=0; i<=n-l; i++) {
				for(int j=0; j<=m-l; j++) {
					if(arr[i][j] == arr[i][j+l-1] && arr[i][j] == arr[i+l-1][j] && arr[i][j] == arr[i+l-1][j+l-1]) {
						System.out.println(l * l);
						return;
					}
				}
			}
			l--;
		}
		System.out.println(l * l);
		
		br.close();
	}
}