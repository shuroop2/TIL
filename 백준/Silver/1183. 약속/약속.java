import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		System.out.println(n % 2 == 1 ? 1 : Math.abs(arr[n / 2] - arr[n / 2 - 1]) + 1);
		
		br.close();
	}
}
