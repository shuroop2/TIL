import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i=0; i<n; i++)
			arr[i] = br.readLine();
		
		int l = arr[0].length();
		
		for(int i=1; i<=l; i++) {
			Set<String> set = new HashSet<>();
			for(int j=0; j<n; j++)
				set.add(arr[j].substring(l - i));
			
			if(set.size() == n) {
				System.out.println(i);
				return ;
			}
		}
		
		br.close();
	}
}