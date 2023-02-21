import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = Integer.toBinaryString(Integer.parseInt(br.readLine()));
		int cnt = 0;
		for(int i=0; i<tmp.length(); i++)
			if(tmp.charAt(i) == '1')
				cnt++;
		
		System.out.println(cnt);
		br.close();
	}
}