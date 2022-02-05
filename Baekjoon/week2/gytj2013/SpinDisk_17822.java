import java.io.*;
import java.util.*;

public class SpinDisk_17822 {
	static int N, M, T;
	static int[][] disk;
	static int[] x, d, k;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		disk = new int[N][M];
		x = new int[T];
		d = new int[T];
		k = new int[T];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				disk[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
			k[i] = Integer.parseInt(st.nextToken());
		}
		int total=0;
		for(int i=0; i<T; i++) {
			rotate(i);
			if(!find()) {
				total=0;
				int num =0;
				for(int x=0; x<N; x++) {
					for(int j=0; j<M; j++) {
						if(disk[x][j]!=0) {
							total += disk[x][j];
							num++;
						}
					}
				}
				if(total==0) {
					System.out.println(total);
					return;
				}
				change(total, num);
			}
		}
		total=0;
		for(int x=0; x<N; x++) {
			for(int j=0; j<M; j++) {
				total += disk[x][j];
			}
		}
		System.out.println(total);
	}
	
	private static void change(int total, int num) {
		double avg = (float)total/num;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(disk[i][j]>0) {
					if(disk[i][j]>avg) {
						disk[i][j] -= 1;
					}else if(disk[i][j]<avg) {
						disk[i][j] += 1;
					}
				}
			}
		}
	}

	private static boolean find() {
		boolean chk = false;
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = disk[i][j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int target = arr[i][j];
				if(target==0) {continue;}
				for(int z=0; z<4; z++) {
					if(i+dx[z]>=0 & i+dx[z]<N & j+dy[z]>=0 & j+dy[z]<M) {
						if(arr[i+dx[z]][j+dy[z]]==target){
							chk = true;
							disk[i+dx[z]][j+dy[z]] = 0;
							disk[i][j] = 0;
						}
					}
					if(j==0 & target == arr[i][M-1]) {
						chk = true;
						disk[i][M-1] = 0;
						disk[i][j] = 0;
					}else if(j==M-1 & target == arr[i][0]) {
						chk = true;
						disk[i][0] = 0;
						disk[i][j] = 0;
					}
				}
			}
		}
		
		return chk;
	}

	private static void rotate(int i) {
		for(int n=x[i]-1; n<N; n+=x[i]) {
			if(d[i]==0) {
				for(int j=0; j<k[i]; j++) {
					int tmp = disk[n][M-1];
					for(int l=M-1; l>0; l--) {
						disk[n][l] = disk[n][l-1];
					}
					disk[n][0]=tmp;
				}
			}else {
				for(int j=0; j<k[i]; j++) {
					int tmp = disk[n][0];
					for(int l=0; l<M-1; l++) {
						disk[n][l] = disk[n][l+1];
					}
					disk[n][M-1]=tmp;
				}
			}
		}
		
	}
}
