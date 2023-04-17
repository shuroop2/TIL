import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        String s = br.readLine();
        for(int i=0; i<s.length(); i++) {
            int num = s.charAt(i) - '0';
            if(num == 6)
                arr[9]++;
            else
                arr[num]++;
        }
        int max = 0;
        for(int i=0; i<9; i++)
            max = Math.max(max, arr[i]);
        int tmp = arr[9] % 2 == 0 ? arr[9] / 2 : arr[9] / 2 + 1;
        
        System.out.println(Math.max(max, tmp));

        br.close();
    }
}