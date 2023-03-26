import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] t = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] d = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		if(d[0] - t[0] > 1000 || (d[0] - t[0] == 1000 && d[1] > t[1]) || (d[0] - t[0] == 1000 && d[1] == t[1] && d[2] >= t[2])) {
			System.out.println("gg");
			return;
		}
		System.out.println("D-" + solv(t, d));
		
		br.close();
	}
	
	public static int[] month(int year) {
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			month[1] = 29;
		return month;
	}
	
	public static int solv(int[] t, int[] d) {
		int[] day = new int[2];
		
		for(int i=t[0]; i<d[0]; i++) {
			if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0)
				day[1] += 366;
			else
				day[1] += 365;
		}
		
		for(int i=0; i<t[1]-1; i++) {
			int[] month = month(t[0]);
			day[0] += month[i];
		}
		day[0] += t[2];
		
		for(int i=0; i<d[1]-1; i++) {
			int[] month = month(d[0]);
			day[1] += month[i];
		}
		day[1] += d[2];
		
		return day[1] - day[0];
	}
}