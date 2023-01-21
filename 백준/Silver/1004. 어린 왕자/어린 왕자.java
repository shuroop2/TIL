import java.util.Scanner;

public class Main {
	static int[] answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		answer = new int[T];
		while (T > 0) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int n = sc.nextInt();
			while(n-- > 0) {
				int nx = sc.nextInt();
				int ny = sc.nextInt();
				int nr = sc.nextInt();
				
				solution(x1, y1, x2, y2, nx, ny, nr, T);
			}
			T--;
		}
		
		for(int i=0; i<answer.length; i++)
			System.out.println(answer[i]);
		
		sc.close();
	}
	
	public static void solution(int x1, int y1, int x2, int y2, int nx, int ny, int nr, int T) {
		boolean result1 = Math.pow(x1 - nx, 2) + Math.pow(y1 - ny, 2) < Math.pow(nr, 2);
		boolean result2 = Math.pow(x2 - nx, 2) + Math.pow(y2 - ny, 2) < Math.pow(nr, 2);
		
		if(result1 ^ result2)
			answer[answer.length - T]++;
		
		return ;
	}
}