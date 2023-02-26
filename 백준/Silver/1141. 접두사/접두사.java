import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			list.add(br.readLine());
		
		Collections.sort(list);
		
		for(int i=0; i<list.size();) {
			if(i+1 < list.size() && list.get(i+1).startsWith(list.get(i)))
				list.remove(i);
			else
				i++;
		}
		
		System.out.println(list.size());
		
		br.close();
	}
}
