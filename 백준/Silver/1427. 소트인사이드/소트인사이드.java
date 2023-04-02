import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] tmp = br.readLine().toCharArray();
		Arrays.sort(tmp);
		System.out.println(new StringBuilder(new String(tmp)).reverse());
		br.close();
	}
}