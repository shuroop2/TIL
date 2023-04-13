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
            if(o1.length() == o2.length())
                return sum(o1) == sum(o2) ? o1.compareTo(o2) : sum(o1) - sum(o2);
            else
                return o1.length() - o2.length();
        });

        for(String str : arr)
            System.out.println(str);

        br.close();
    }

    public static int sum(String str) {
        int result = 0;

        for(char c : str.replaceAll("[^\\d]", "").toCharArray())
            result += c - '0';
        
        return result;
    }
}