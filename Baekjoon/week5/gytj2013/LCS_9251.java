import java.io.*;

public class LCS_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int len = s2.length();
		int[] num = new int[len];
		int[] prenum = new int[len];
		
		for(int l=0; l<s1.length(); l++) {
			char c = s1.charAt(l);
			int idx = 0;
			while(true) {
				int i = s2.indexOf(c, idx);
				if(i==-1) break;
				for(int j=i; j<len; j++) {
					if(j==0) {
						if(num[0]==1) break;
						num[0] = 1; 
						continue;
					}
					if(num[j]>=prenum[j-1]+1) break;
					num[j] = prenum[j-1]+1;
				}
				idx = i+1;
			}
			prenum = num.clone();
		}
		
		System.out.println(num[len-1]);
	}
}
