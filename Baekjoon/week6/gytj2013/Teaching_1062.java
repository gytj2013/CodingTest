import java.io.*;
import java.util.*;

public class Teaching_1062 {
	static int N, K;
	static int ans = 0;
	static List<Set<Character>> word = new ArrayList<>();
	static Set<Character> result = new HashSet<>();
	static List<Character> list;
	static char[] select;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(K==0) {System.out.println(0); return;}
		if(K==26) {System.out.println(N); return;}
		Set<Character> set;
		for(int i=0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
			set = new HashSet<>();
			for(char c : tmp) { set.add(c); }
			if(set.size()<=K) {
				word.add(set);
			}
		}
		int num = word.size();
		if(num==0) {System.out.println(0); return;}
		for(char c : word.get(0)) {
			int cnt = 0;
			for(Set s : word) {
				if(s.contains(c)) cnt++;
				else break;
			}
			if(cnt == num) {
				result.add(c);
			}
		}
		for(char c : result) {
			for(Set s : word) {
				s.remove(c);
			}
		}
		K -= result.size();
		result = new HashSet<>();
		for(Set s : word) {
			if(s.isEmpty()) {ans++;}
			else result.addAll(s);
		}
		if(K==0 | result.isEmpty()) {System.out.println(ans); return;}
		if(K>=result.size()) {System.out.println(num); return;}
		list = new ArrayList<>(result);
		select = new char[K];
		comb(0, 0, ans);
		System.out.println(ans);
	}
	private static void comb(int cnt, int start, int num) {
		if(cnt==K) {
			String tmp = Arrays.toString(select);
			int n = num;
			for(int i=0; i<word.size(); i++) {
				if(word.get(i).isEmpty()) continue;
				boolean chk = false;
				for(char c : word.get(i)) {
					if(!tmp.contains(c+"")) {
						chk = true;
						break;
					}
				}
				if(!chk) n++;
			}
			ans = Math.max(ans, n);
			return;
		}
		for(int i=start; i<list.size(); i++) {
			select[cnt] = list.get(i);
			comb(cnt+1, i+1, num);
		}
	}
}
