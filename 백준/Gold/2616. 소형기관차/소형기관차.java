
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);
        arr = new int[n+1];
        sum = new int[n+1];
        int[][] dp = new int[4][n+1];

        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 1; i < 4; i++) {
            for (int j = i * m; j <= n; j++) {
                dp[i][j] = Math.max(
                        dp[i][j-1],
                        dp[i-1][j-m] + (sum[j] - sum[j-m])
                );
            }
        }

        System.out.println(dp[3][n]);
    }
}