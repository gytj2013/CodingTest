import java.util.*;

class Hanoi{
	String A, B, C;
	int a, b, c;
	int cnt;
	Hanoi(String A, String B, String C, int a, int b, int c, int cnt){
		this.A = A;
		this.B = B;
		this.C = C;
		this.a = a;
		this.b = b;
		this.c = c;
		this.cnt = cnt;
	}
}


public class NewHanoiTower_12906 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String A = "";
		if(a>0) A = sc.next();
		
		int b = sc.nextInt();
		String B = "";
		if(b>0) B = sc.next();
		
		int c = sc.nextInt();
		String C = "";
		if(c>0) C = sc.next();
		
		Set<String> set = new HashSet<>();
		Queue<Hanoi> q = new LinkedList<>();
		q.add(new Hanoi(A, B, C, a, b, c, 0));
		set.add(A+" "+B+" "+C);
		
		
		while(!q.isEmpty()) {
			Hanoi h = q.poll();
			A = h.A;
			B = h.B;
			C = h.C;
			a = h.a;
			b = h.b;
			c = h.c;
			int cnt = h.cnt;
			if(check(A,B,C)) {
				System.out.println(cnt);
				break;
			}
			if(a!=0) {
				String newA = A.substring(0,a-1);
				char last = A.charAt(a-1);
				if(!set.contains(newA+" "+B+last+" "+C)) {
					q.add(new Hanoi(newA, B+last, C, a-1, b+1, c, cnt+1));
					set.add(newA+" "+B+last+" "+C);
				}
				if(!set.contains(newA+" "+B+" "+C+last)) {
					q.add(new Hanoi(newA, B, C+last, a-1, b, c+1, cnt+1));
					set.add(newA+" "+B+" "+C+last);
				}
			}
			if(b!=0) {
				String newB = B.substring(0,b-1);
				char last = B.charAt(b-1);
				if(!set.contains(A+last+" "+newB+" "+C)) {
					q.add(new Hanoi(A+last, newB, C, a+1, b-1, c, cnt+1));
					set.add(A+last+" "+newB+" "+C);
				}
				if(!set.contains(A+" "+newB+" "+C+last)) {
					q.add(new Hanoi(A, newB, C+last, a, b-1, c+1, cnt+1));
					set.add(A+" "+newB+" "+C+last);
				}
			}
			if(c!=0) {
				String newC = C.substring(0,c-1);
				char last = C.charAt(c-1);
				if(!set.contains(A+last+" "+B+" "+newC)) {
					q.add(new Hanoi(A+last, B, newC, a+1, b, c-1, cnt+1));
					set.add(A+last+" "+B+" "+newC);
				}
				if(!set.contains(A+" "+B+last+" "+newC)) {
					q.add(new Hanoi(A, B+last, newC, a, b+1, c-1, cnt+1));
					set.add(A+" "+B+last+" "+newC);
				}
			}
		}
	}

	private static boolean check(String A, String B, String C) {
		if(A.contains("B")|A.contains("C")) {
			return false;
		}
		if(B.contains("A")|B.contains("C")) {
			return false;
		}
		if(C.contains("B")|C.contains("A")) {
			return false;
		}
		return true;
	}
}
