import java.util.*;

public class PartialSum2_1208 {
	static int N, S;
	static int[] arr;
	static List<Long> list1 = new ArrayList<>();
	static List<Long> list2 = new ArrayList<>();
	static long ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		comb1(0,0);
		comb2(0,N/2);
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		int idx1 = 0;
		int idx2 = list2.size()-1;
		long tmp = 0;
		
		while(idx1 < list1.size() & idx2>=0) {
			long a = list1.get(idx1);
			long b = list2.get(idx2);
			
			if(a+b==S) {
				long n1 = 0;
				long n2 = 0;
				while(idx1 < list1.size()) {
					if(list1.get(idx1)!=a) break;
					n1++;
					idx1++;
				}
				while(idx2>=0) {
					if(list2.get(idx2)!=b) break;
					n2++;
					idx2--;
				}
				ans += n1*n2;
			}else if(a+b>S) {
				idx2--;
			}else {
				idx1++;
			}
		}
		
		if(S==0) {
			ans-=1;
		}
		System.out.println(ans);
	}
	private static void comb1(long total, int st) {
		list1.add(total);
		for(int i=st; i<N/2; i++) {
			comb1(total+arr[i], i+1);
		}
	}
	private static void comb2(long total, int st) {
		list2.add(total);
		for(int i=st; i<N; i++) {
			comb2(total+arr[i], i+1);
		}
	}
}
