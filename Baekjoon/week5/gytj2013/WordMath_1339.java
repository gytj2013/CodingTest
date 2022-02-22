import java.io.*;
import java.util.*;

public class WordMath_1339 {
	static int N;
	static int len;
	static int answer = 0;
	static boolean[] visited = new boolean[10];
	static List<Character> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String word = "";
		for(int i=0; i<N; i++) {
			word += br.readLine();
			word += "+";
		}
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(list.contains(c) | c=='+') {
				continue;
			}else {
				list.add(c);
			}
		}
		len = list.size();
		permu(0, word);
		System.out.println(answer);
	}
	private static void permu(int cnt, String word) {
		if(cnt==len) {
			String[] arr = word.split("\\+");
			int ans =0;
			for(int i=0; i<N; i++) {
				ans += Integer.parseInt(arr[i]);
			}
			answer = Math.max(answer, ans);
			return;
		}
		for(int i=9; i>9-len; i--) {
			if(visited[i]) continue;
			visited[i] = true;
			permu(cnt+1, word.replace(list.get(cnt)+"", i+""));
			visited[i] = false;
		}
		
	}
}
