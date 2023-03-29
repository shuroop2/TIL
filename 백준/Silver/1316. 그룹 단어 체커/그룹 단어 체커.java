import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while(n-- > 0) {
			List<Character> list = new ArrayList<>();
			String tmp = br.readLine();
			boolean flag = true;
			for(int i=0; i<tmp.length(); i++) {
				if(list.contains(tmp.charAt(i))) {
					if(tmp.charAt(i) != tmp.charAt(i-1)) {
						flag = false;
						break;
					}
				} else {
					list.add(tmp.charAt(i));
				}
			}
			if(flag)
				cnt++;
		}
		System.out.println(cnt);
		
		br.close();
	}
}