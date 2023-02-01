
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
//        StringTokenizer st;

        n = Integer.parseInt(str);

        int[] arr = new int[1000];
        int[] dp = new int[1000];

        int pnt = 0;
        for(int i = 1; i < 1000; i++){
            arr[i] = arr[i-1] + i;
            dp[i] = dp[i-1] + arr[i];

            if(dp[i] > n){
                pnt = i;
                break;
            }
        }

//        for(int i = 1; i <= pnt; i++) System.out.print(dp[i] + " ");
//        System.out.println();

        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;

        for(int i = 1; i <= n; i++){
            for (int j = 1; j < 122; j++) {
                if(dp[j] > i) break;
                res[i] = Math.min(res[i], res[i-dp[j]] + 1);
            }
        }

        System.out.println(res[n]);
    }
}