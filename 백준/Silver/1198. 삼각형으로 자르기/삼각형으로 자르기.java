import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double answer = 0;
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n-2; i++)
			for(int j=i+1; j<n-1; j++)
				for(int k=j+1; k<n; k++)
					answer = Math.max(answer, Math.abs(arr[i][0] * arr[j][1] + arr[j][0] * arr[k][1] + arr[k][0] * arr[i][1] - arr[j][0] * arr[i][1] - arr[k][0] * arr[j][1] - arr[i][0] * arr[k][1]));

		System.out.println(answer / 2);
		
		br.close();
	}
}
