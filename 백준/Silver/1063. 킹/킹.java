import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] king = st.nextToken().toCharArray();
		char[] stone = st.nextToken().toCharArray();
		int n = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			char[] tmpK = king.clone();
			char[] tmpS = stone.clone();
			
			move(tmp, tmpK);
			
			if(!range(tmpK))
				continue;
			
			if(Arrays.equals(tmpK, tmpS)) {
				move(tmp, tmpS);
				if(!range(tmpS))
					continue;
			}
			king = tmpK;
			stone = tmpS;
		}
		System.out.println(king);
		System.out.println(stone);
		
		br.close();
	}
	
	public static boolean range(char[] arr) {
		return (arr[0] >= 'A' && arr[0] <= 'H' && arr[1] >= '1' && arr[1] <= '8');
	}
	
	public static void move(String s, char[] arr) {
		switch(s) {
			case "R": arr[0]++; break;
	        case "L": arr[0]--; break;
	        case "B": arr[1]--; break;
	        case "T": arr[1]++; break;
	        case "RT": arr[0]++; arr[1]++; break;
	        case "LT": arr[0]--; arr[1]++; break;
	        case "RB": arr[0]++; arr[1]--; break;
	        case "LB": arr[0]--; arr[1]--; break;
		}
	}
}