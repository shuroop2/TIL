import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		int[] x = new int[3];
		int[] y = new int[3];
		String s = br.readLine();
		x[0] = x[1] = s.charAt(0);
		y[0] = y[1] = s.charAt(1);
		list.add(s);
		
		for(int i=0; i<35; i++) {
			s = br.readLine();
			x[2] = s.charAt(0);
			y[2] = s.charAt(1);
			
			if(list.contains(s)) {
				System.out.println("Invalid");
				return;
			}
			
			if(!(Math.abs(x[2] - x[1]) == 2 && Math.abs(y[2] - y[1]) == 1 || Math.abs(x[2] - x[1]) == 1 && Math.abs(y[2] - y[1]) == 2)) {
				System.out.println("Invalid");
				return;
			}
			
			list.add(s);
			x[1] = x[2];
			y[1] = y[2];
		}
		
		if(!(Math.abs(x[2] - x[0]) == 2 && Math.abs(y[2] - y[0]) == 1 || Math.abs(x[2] - x[0]) == 1 && Math.abs(y[2] - y[0]) == 2)) {
			System.out.println("Invalid");
			return;
		}
		
		System.out.println("Valid");
		
		br.close();
	}
}
