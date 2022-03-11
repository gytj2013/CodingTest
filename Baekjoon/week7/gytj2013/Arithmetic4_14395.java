import java.util.*;

class Method{
	long num;
	String way;
	Method(long num, String way){
		this.num=num;
		this.way=way;
	}
}

public class Arithmetic4_14395 {
	static long s, t;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextLong();
		t = sc.nextLong();
		if(s==t) {
			System.out.println(0);
			return;
		}
		if(t==1) {
			System.out.println("/");
			return;
		}
		Queue<Method> q = new LinkedList<>();
		q.add(new Method(s, ""));
		boolean chk = false;
		while(!q.isEmpty()) {
			Method m = q.poll();
			long num = m.num;
			String way = m.way;
			//System.out.println(num+", "+way);
			if(num==t) {
				System.out.println(way);
				return;
			}
			if(num!=1 & num*num <= t) q.add(new Method(num*num, way+"*"));
			if(num!=2 & 2*num <= t) q.add(new Method(2*num, way+"+"));
			if(num!=1 & !chk) {q.add(new Method(1, "/")); chk = true;}
		}
		System.out.println(-1);
	}
}
