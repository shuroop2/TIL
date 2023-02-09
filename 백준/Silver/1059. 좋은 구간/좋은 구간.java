import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		int[] arr = new int[l];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<l; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int n = Integer.parseInt(br.readLine());
		int min = 0, max = 999999999;
		for(int i=0; i<l; i++) {
			if(n > arr[i]) {
				min = Math.max(min, arr[i]);
			} else if(n < arr[i])
				max = Math.min(max, arr[i]);
			else {
				System.out.println(0);
				return;
			}
		}
		System.out.println((max - n) * (n - min) - 1);
		
		br.close();
	}
}