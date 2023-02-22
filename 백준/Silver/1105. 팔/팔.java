import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String l = st.nextToken();
		String r = st.nextToken();
		int answer = 0;
		
		if(l.length() == r.length()) {
			for(int i=0; i<l.length(); i++) {
				if(l.charAt(i) == r.charAt(i) && l.charAt(i) == '8')
					answer++;
				else if(l.charAt(i) != r.charAt(i))
					break;
			}
		}
		System.out.println(answer);
		
		br.close();
	}
}
