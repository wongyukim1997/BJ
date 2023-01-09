
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int[] dp = new int[n];
        
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++) {
        	dp[i] = 1;
        	
        	for(int j = 0; j < i; j++) {
        		if(arr[j] < arr[i] && dp[i] < dp[j]+1) {
        			dp[i] = dp[j]+1;
        			max = Math.max(dp[i], max);
        		}
        	}
        }
        
//        System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }
}