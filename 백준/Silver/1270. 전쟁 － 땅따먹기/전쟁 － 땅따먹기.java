import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
        	System.gc();
        	Map<Long, Integer> map = new HashMap<>();
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	
        	for(int j=0; j<num; j++) {
        		long str = Long.parseLong(st.nextToken());
            	map.put(str, map.getOrDefault(str, 0) + 1);
        	}
        	
        	List<Long> keySet = new ArrayList<>(map.keySet());
        	Collections.sort(keySet, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        	sb.append(map.get(keySet.get(0)) > num / 2 ? keySet.get(0) : "SYJKGW").append("\n");
        }
        System.out.println(sb.toString());
        
        br.close();
	}
}
