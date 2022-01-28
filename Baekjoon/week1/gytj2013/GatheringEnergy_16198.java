import java.io.*;
import java.util.*;

public class GatheringEnergy_16198 {
	static int N;
	static int max=0;
	static LinkedList<Integer> W = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			W.add(Integer.parseInt(st.nextToken()));
		}
		recurr(0, N);		
		System.out.println(max);
	}
	private static void recurr(int energy, int n) {
		if(n==2) {
			max = Math.max(max, energy);
			return;
		}
		for(int i=1; i<n-1; i++) {
			int add = W.get(i-1) * W.get(i+1);
			int tmp = W.remove(i);
			recurr(energy + add, n-1);
			W.add(i, tmp);
		}
		
	}
}
