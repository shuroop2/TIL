import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		
		for(int i=0; i<n; i++)
			arr[i] = br.readLine();
		
		Arrays.sort(arr, (o1, o2) -> {
			return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
		});
		
		System.out.println(arr[0]);
		for(int i=1; i<n; i++)
			if(!arr[i].equals(arr[i-1]))
				System.out.println(arr[i]);
		
		br.close();
	}
}