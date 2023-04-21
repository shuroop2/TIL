import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tmp = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[101][101];
        int cnt = 0;
        while(tmp[0]-- > 0) {
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=arr[0]; i<=arr[2]; i++)
                for(int j=arr[1]; j<=arr[3]; j++)
                    map[i][j]++;
        }

        for(int[] a : map)
            for(int b : a)
                if(b > tmp[1])
                    cnt++;
        
        System.out.println(cnt);

        br.close();
    }
}
