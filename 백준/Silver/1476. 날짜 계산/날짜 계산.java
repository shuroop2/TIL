import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] tmp = new int[3];

        for(int i=0; ; i++) {
            if(Arrays.equals(arr, tmp)) {
                System.out.println(i);
                break;
            }
            tmp[0]++;
            tmp[1]++;
            tmp[2]++;
            if(tmp[0] == 16)
                tmp[0] = 1;
            if(tmp[1] == 29)
                tmp[1] = 1;
            if(tmp[2] == 20)
                tmp[2] = 1;
        }

        br.close();
    }
}