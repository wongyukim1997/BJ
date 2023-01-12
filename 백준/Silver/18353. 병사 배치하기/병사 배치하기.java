
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		str = bf.readLine();
		st = new StringTokenizer(str, " ");
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 1;
		if(n == 1) System.out.println(0);
		else {
			int max = 1;	
			
			for(int i = 2; i <= n; i++) {
				dp[i] = 1;
				
				for(int j = 1; j < i; j++) {
					if(arr[i] < arr[j] && dp[i] <= dp[j]+1) {
						dp[i] = dp[j] + 1;
						max = Math.max(max, dp[i]);
					}
				}
			}
			if(max == 0) System.out.println(n-1);
			else System.out.println(n-max);
		}
	}

}
