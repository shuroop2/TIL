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
		boolean[][] a = new boolean[n][m];
		boolean[][] b = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++)
				a[i][j] = tmp.charAt(j) == '1' ? true : false; 
		}
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++)
				b[i][j] = tmp.charAt(j) == '1' ? true : false; 
		}
		
		int cnt = 0;
		for(int i=0; i<=n-3; i++) {
			for(int j=0; j<=m-3; j++) {
				if(a[i][j] != b[i][j]) {
					cnt++;
					for(int k=i; k<i+3; k++)
						for(int l=j; l<j+3; l++)
							a[k][l] = !a[k][l];
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] != b[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(cnt);
        
		br.close();
	}
}