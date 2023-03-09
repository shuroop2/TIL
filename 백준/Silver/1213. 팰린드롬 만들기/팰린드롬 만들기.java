import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String answer = "";
		char[] name = br.readLine().toCharArray();
		int[] arr = new int[26];
		
		for(int i=0; i<name.length; i++)
			arr[name[i] - 'A']++;
		
		int cnt = 0;
		for(int i=0; i<arr.length; i++)
			if(arr[i] % 2 != 0)
				cnt++;
		
		if(cnt > 1) {
			System.out.println("I'm Sorry Hansoo");
			return ;
		} else {
			for(int i=0; i<26; i++)
				for(int j=0; j<arr[i]/2; j++)
					sb.append((char) (i + 'A'));
			answer += sb.toString();
			
			for(int i=0; i<26; i++)
				if(arr[i] % 2 == 1)
					answer += (char) (i + 'A');
			
			answer += sb.reverse().toString();
		}
		
		System.out.println(answer);
		
		br.close();
	}
}