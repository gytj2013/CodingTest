import java.io.*;
import java.util.*;

class Num {
	String str;
	int cnt;
	Num(String str, int cnt) {
		this.str = str;
		this.cnt = cnt;
	}
}

public class PrimeNumRoute {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		String[] s;
		for(int l=0; l<T; l++) {
			s = br.readLine().split(" ");
			if(s[0].equals(s[1])) {
				System.out.println(0);
				continue;
			}
			boolean[] visited = new boolean[10000];
			Queue<Num> q = new LinkedList<>();
			q.add(new Num(s[0], 0));
			visited[Integer.parseInt(s[0])] = true;
			int ans = Integer.MAX_VALUE;
			while(!q.isEmpty()) {
				Num n = q.poll();
				String str = n.str;
				int cnt = n.cnt;
				//System.out.println(str+", "+cnt);
				if(cnt > ans) {continue;}
				if(str.equals(s[1])) {
					ans = cnt;
				}
				for(int i=0; i<=9; i++) {
					for(int j=0; j<4; j++) {
						if(str.charAt(j)-'0'==i) {continue;}
						if(i==0 & j==0) {continue;}
						String newstr = str.substring(0,j) + i + str.substring(j+1);
						int newint = Integer.parseInt(newstr);
						if(visited[newint]) continue;
						if(!isPrime(newint)) continue;
						visited[newint] = true;
						q.add(new Num(newstr, cnt+1));
					}
				}
			}
			if(ans==Integer.MAX_VALUE) {
				System.out.println("Impossible");
			}else {
				System.out.println(ans);
			}
		}
	}

	private static boolean isPrime(int newint) {
		for(int i=2; i<newint; i++) {
			if(newint%i==0) return false;
		}
		return true;
	}
}
