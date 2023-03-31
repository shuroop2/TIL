import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"AAAA", "BB"};
        String tmp = br.readLine().replaceAll("XXXX", arr[0]).replaceAll("XX", arr[1]);;

        System.out.println(tmp.contains("X") ? "-1" : tmp);

        br.close();
    }
}