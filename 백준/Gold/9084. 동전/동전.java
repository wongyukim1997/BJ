import java.util.*;
import java.io.*;

public class Main {
    static int n, c;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int T = Integer.parseInt(str);

        for(int t = 0; t < T; t++){
            str = br.readLine();
            n = Integer.parseInt(str);
            arr = new int[n];

            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            str = br.readLine();
            c = Integer.parseInt(str);
            dp = new int[c+1];

            dp[0] = 1;

            for(int i = 0; i < n; i++){
                for(int j = arr[i]; j < c+1; j++){
//                    System.out.println(j);
                    dp[j] += dp[j-arr[i]];
                }
            }

            System.out.println(dp[c]);
        }
    }

}
