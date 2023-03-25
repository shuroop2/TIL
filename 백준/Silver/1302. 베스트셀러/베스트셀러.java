import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		while(n-- > 0 ) {
			String tmp = br.readLine();
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
		}
		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
		List<String> list = new ArrayList<>();
		
		for(String key : keySet)
			if(map.get(key) == map.get(keySet.get(0)))
				list.add(key);
		
		Collections.sort(list);
		System.out.println(list.get(0));
		
		br.close();
	}
}