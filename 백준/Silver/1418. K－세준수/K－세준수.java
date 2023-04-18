import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        
        for(int i=k+1; i<=n; i++) {
            boolean flag = true;
            for(int j=2; j<i; j++) {
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag)
                for(int j=1; j*i<=n; j++)
                    arr[i * j] = 0;
        }

        for(int i=1; i<=n; i++)
            if(arr[i] == 1)
                cnt++;

        System.out.println(cnt);
        
        br.close();
    }
}