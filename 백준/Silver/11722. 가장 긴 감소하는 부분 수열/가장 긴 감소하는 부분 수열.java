import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);
        arr = new int[n];
        dp = new int[n];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[n-1] = 1;
        int max = 1;

        for(int i = n-2; i >= 0; i--){
            dp[i] = 1;
            for (int j = i+1; j < n; j++) {
//                System.out.println(arr[i] + " " + i + " " + arr[j] + " " + j);
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
//                    System.out.println(arr[i] + " " + arr[j] + " " + dp[i] + " " + dp[j]);
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }
}