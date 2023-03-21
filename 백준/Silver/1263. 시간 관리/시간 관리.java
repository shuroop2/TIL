import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) ->  o2[1] - o1[1]);
        
        int tmp = arr[0][1] - arr[0][0];
        for(int i=1; i<arr.length; i++) {
        	if(arr[i][1] < tmp)
        		tmp = arr[i][1];
        	tmp -= arr[i][0];
        }
        System.out.println(tmp > 0 ? tmp : -1);

        br.close();
	}
}
