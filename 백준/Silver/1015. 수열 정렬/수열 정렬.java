import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		int[] arr1 = new int[T];
		int[] arr2 = new int[T];
		
		for(int i=0; i<T; i++) {
			arr1[i] = Integer.parseInt(tmp[i]);
			arr2[i] = Integer.parseInt(tmp[i]);
		}
		
		Arrays.sort(arr2);
		
		for(int i=0; i<T; i++) {
			for(int j=0; j<T; j++) {
				if(arr1[i] == arr2[j]) {
					sb.append(j + " ");
					arr2[j] = 0;
					break;
				}
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}