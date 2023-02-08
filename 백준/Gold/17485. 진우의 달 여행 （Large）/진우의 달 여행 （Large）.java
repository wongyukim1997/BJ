import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n, m;
    static int min = Integer.MAX_VALUE;

    static int[][] arr;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[3][n][m];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //초기화
        for(int i = 0; i < m; i++) {
            dp[0][0][i] = arr[0][i];
            dp[1][0][i] = arr[0][i];
            dp[2][0][i] = arr[0][i];
        }

        for(int i = 1; i < n; i++){
            dp[0][i][0] = Integer.MAX_VALUE;
            dp[2][i][m-1] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j-1 >= 0 && j+1 < m){
                    dp[0][i][j] = Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1]) + arr[i][j];
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + arr[i][j];
                    dp[2][i][j] = Math.min(dp[0][i-1][j+1], dp[1][i-1][j+1]) + arr[i][j];
                }
                else if(!(j-1 >= 0) && j+1 < m){
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + arr[i][j];
                    dp[2][i][j] = Math.min(dp[0][i-1][j+1], dp[1][i-1][j+1]) + arr[i][j];
                }
                else if(j-1 >= 0 && !(j+1 < m)){
                    dp[0][i][j] = Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1]) + arr[i][j];
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + arr[i][j];
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < 3; j++){
                min = Math.min(dp[j][n-1][i], min);
//                System.out.println(min);
            }
        }

        System.out.println(min);
    }
}