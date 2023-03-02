import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			if(!list.contains(tmp))
				list.add(tmp);
		}
		
		Collections.sort(list, (o1, o2) -> {
			return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
		});
		
		for(String s : list)
			System.out.println(s);
		
		br.close();
	}
}