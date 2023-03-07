import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int cnt = 1;
		
		if(n > 0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n == p && score <= arr[arr.length - 1])
            System.out.println(-1);
        else {
            for(int i=0; i<arr.length; i++) {
                if(score < arr[i])
                    cnt++;
                else
                    break;
            }
            
            System.out.println(cnt);
        }
		
		br.close();
	}
}