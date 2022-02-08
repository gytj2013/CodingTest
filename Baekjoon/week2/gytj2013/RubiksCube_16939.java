import java.io.*;
import java.util.*;

public class RubiksCube_16939 {
	static int[] cube = new int[25];
	static int[] tmp = new int[25];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<25; i++) {
			cube[i] = Integer.parseInt(st.nextToken());
		}
		changeR(1, 3, 5, 7, 9, 11, 24, 22);
		if(check()) {System.out.println(1); return;}
		changeL(1, 3, 5, 7, 9, 11, 24, 22);
		if(check()) {System.out.println(1); return;}
		changeR(2, 4, 6, 8, 10, 12, 23, 21);
		if(check()) {System.out.println(1); return;}
		changeL(2, 4, 6, 8, 10, 12, 23, 21);
		if(check()) {System.out.println(1); return;}
		changeR(13, 14, 5, 6, 17, 18, 21, 22);
		if(check()) {System.out.println(1); return;}
		changeL(13, 14, 5, 6, 17, 18, 21, 22);
		if(check()) {System.out.println(1); return;}
		changeR(15, 16, 7, 8, 19, 20, 23, 24);
		if(check()) {System.out.println(1); return;}
		changeL(15, 16, 7, 8, 19, 20, 23, 24);
		if(check()) {System.out.println(1); return;}
		changeR(3, 4, 17, 19, 10, 9, 16, 14);
		if(check()) {System.out.println(1); return;}
		changeL(3, 4, 17, 19, 10, 9, 16, 14);
		if(check()) {System.out.println(1); return;}
		changeR(1, 2, 18, 20, 12, 11, 15, 13);
		if(check()) {System.out.println(1); return;}
		changeL(1, 2, 18, 20, 12, 11, 15, 13);
		if(check()) {System.out.println(1); return;}
		
		System.out.println(0);
	}
	private static void changeR(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8) {
		for(int i=1; i<25; i++) {
			tmp[i] = cube[i];
		}
		
		tmp[a1] = tmp[a3];
		tmp[a2] = tmp[a4];
		tmp[a3] = tmp[a5];
		tmp[a4] = tmp[a6];
		tmp[a5] = tmp[a7];
		tmp[a6] = tmp[a8];
		tmp[a7] = cube[a1];
		tmp[a8] = cube[a2];
		
	}
	private static void changeL(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8) {
		for(int i=1; i<25; i++) {
			tmp[i] = cube[i];
		}
		
		tmp[a8] = tmp[a6];
		tmp[a7] = tmp[a5];
		tmp[a6] = tmp[a4];
		tmp[a5] = tmp[a3];
		tmp[a4] = tmp[a2];
		tmp[a3] = tmp[a1];
		tmp[a2] = cube[a8];
		tmp[a1] = cube[a7];
		
	}
	private static boolean check() {
		if(!(tmp[1]==tmp[2] & tmp[2]==tmp[3] & tmp[3]==tmp[4])) {
			return false;
		}
		if(!(tmp[5]==tmp[6] & tmp[6]==tmp[7] & tmp[7]==tmp[8])) {
			return false;
		}
		if(!(tmp[9]==tmp[10] & tmp[10]==tmp[11] & tmp[11]==tmp[12])) {
			return false;
		}
		if(!(tmp[13]==tmp[14] & tmp[14]==tmp[15] & tmp[15]==tmp[16])) {
			return false;
		}
		if(!(tmp[17]==tmp[18] & tmp[18]==tmp[19] & tmp[19]==tmp[20])) {
			return false;
		}
		if(!(tmp[21]==tmp[22] & tmp[22]==tmp[23] & tmp[23]==tmp[24])) {
			return false;
		}
		return true;
	}
}
