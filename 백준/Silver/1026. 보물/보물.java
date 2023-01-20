import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] A = new int[T];
		int[] B = new int[T];
		
		for(int i=0; i<T; i++)
			A[i] = sc.nextInt();
		
		for(int i=0; i<T; i++)
			B[i] = sc.nextInt();
		
		Arrays.sort(A);
		B = Arrays.stream(B)
				.boxed()
				.sorted(Collections.reverseOrder())
				.mapToInt(Integer::intValue)
				.toArray();
		
		int answer = 0;
		
		for(int i=0; i<T; i++)
			answer += A[i] * B[i];
		
		System.out.println(answer);

		sc.close();
	}
}