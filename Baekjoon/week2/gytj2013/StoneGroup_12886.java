import java.io.*;
import java.util.*;

class Num{
	int a, b, c;
	Num(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class StoneGroup_12886 {
	static int A, B, C;
	static int answer = 0;
	static boolean[][] visited = new boolean[1501][1501];
	static Queue<Num> q = new LinkedList<Num>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		if((A+B+C)%3==0) {
			q.add(new Num(A, B, C));
			while(!q.isEmpty()) {
				Num n = q.poll();
				A = n.a;
				B = n.b;
				C = n.c;
				if(A==B & B==C) {
					answer=1;
					break;
				}
				calc(A, B, C);
				calc(B, C, A);
				calc(C, A, B);
			}
		}
		
		System.out.println(answer);
	}
	private static void calc(int A, int B, int tmp) {
		if(A==B) {return;}
		int X = A<B?A:B;
		int Y = A>B?A:B;
		if(!visited[2*X][Y-X]) {
			visited[2*X][Y-X] = true;
			q.add(new Num(2*X, Y-X, tmp));
			
		}
		
	}
}
