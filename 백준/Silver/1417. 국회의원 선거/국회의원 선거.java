import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int tmp = Integer.parseInt(br.readLine());
		int[] a = {tmp, tmp};
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		while(n-- > 1) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		while(!pq.isEmpty() && pq.peek() >= a[1]) {
			a[1]++;
			pq.add(pq.poll() - 1);
		}
		System.out.println(a[1] - a[0]);
		
		br.close();
	}
}