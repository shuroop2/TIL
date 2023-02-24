import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] tall = new int[n];
        List<Integer> ans = new ArrayList<>();
 
        for(int i=0; i<n; i++)
            tall[i] = Integer.parseInt(st.nextToken());
 
        for(int i=n-1; i>=0; i--)
            ans.add(tall[i], i + 1);
 
        for(int k : ans)
            System.out.print(k+" ");
        
		br.close();
	}
}
