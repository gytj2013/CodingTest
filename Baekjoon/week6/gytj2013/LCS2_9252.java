import java.io.*;

public class LCS2_9252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int len1 = s1.length();
		int len2 = s2.length();
		int[][] num = new int[len1+1][len2+1];
		String ans = "";
		
		for(int l=1; l<=len1; l++) {
			char c = s1.charAt(l-1);
			int idx = 0;
			num[l] = num[l-1].clone();
			while(true) {
				int i = s2.indexOf(c, idx);
				if(i==-1) break;
				for(int j=i+1; j<=len2; j++) {
					if(j==1) {
						if(num[l][1]==1) break;
						num[l][1] = 1; 
						continue;
					}
					if(num[l][j]>=num[l-1][j-1]+1) break;
					num[l][j] = num[l-1][j-1]+1;
				}
				idx = i+1;
			}
		}
		int i=len1;
		int j=len2;
		while(true) {
			if(i<1 | j<1) break;
			if(num[i][j]==num[i][j-1]) {
				j--;
			}
			else if(num[i][j]==num[i-1][j]) {
				i--;
			}
			else {
				ans = s1.charAt(i-1)+ans;
				i--; j--;
			}
		}
		
		System.out.println(num[len1][len2]);
		if(num[len1][len2]>0) {
			System.out.println(ans);
		}
	}
}
