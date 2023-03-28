import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = arr[0] % arr[1];
        
        for(int i=0; i<arr[2]-1; i++) {
        	result *= 10;
        	result %= arr[1];
        }
        result *= 10;
        
        System.out.println(result / arr[1]);
        
        br.close();
    }
}