import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double N = Double.parseDouble(st.nextToken());
		double L = Double.parseDouble(st.nextToken());
		double tmp = 0;
		
		while(true) {
			tmp = N / L;
			if(L > 100) {
				System.out.println("-1");
				break;
			} else if (tmp - (L / 2 - 0.5) < 0) {
				System.out.println("-1");
				break;
			}
			
			if(L % 2 == 0) {
				if(tmp % 1 == 0.5) {
					for(int i=(int)(tmp-(L/2-0.5)); i<tmp+(L/2+0.5); i++)
						System.out.print(i + " ");
					break;
				}
			} else if (L % 2 == 1) {
				if(tmp % 1 == 0) {
					for(int i=(int)(tmp-(L/2-0.5)); i<tmp+(L/2+0.5); i++)
						System.out.print(i + " ");
					break;
				}
			}
			L++;
		}
		
		br.close();
	}
}