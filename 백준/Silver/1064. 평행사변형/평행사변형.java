import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double[] p = Stream.of(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		
		if((p[0] - p[2]) * (p[1] - p[5]) == (p[0] - p[4]) * (p[1] - p[3])) {
			System.out.println(-1.0);
			return;
		}
		
		double ab = Math.sqrt(Math.pow((p[0] - p[2]), 2) + Math.pow((p[1] - p[3]), 2));
		double ac = Math.sqrt(Math.pow((p[0] - p[4]), 2) + Math.pow((p[1] - p[5]), 2));
		double bc = Math.sqrt(Math.pow((p[2] - p[4]), 2) + Math.pow((p[3] - p[5]), 2));
		
		double result = Math.max(ab, Math.max(ac, bc)) - Math.min(ab, Math.min(ac, bc));
		System.out.println(result * 2);
		
		br.close();
	}
}