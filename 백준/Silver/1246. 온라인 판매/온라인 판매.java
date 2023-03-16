import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		int[] max = new int[2];
		
		for(int i=0; i<m; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		for(int i=0; i<m; i++) {
			int now = m - i < n ? arr[i] * (m - i) : arr[i] * n;
			if(max[0] < now) {
				max[0] = now;
				max[1] = arr[i];
			}
		}
		System.out.println(max[1] + " " + max[0]);
		
		br.close();
	}
}