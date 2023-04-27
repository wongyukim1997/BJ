import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][] pre;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);
        map = new int[n+1][n+1];
        pre = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                pre[i][j] = map[i][j] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
            }
        }

        int max = Integer.MIN_VALUE;

        for(int k = 1; k <= n; k++) {
            for (int i = k; i <= n; i++) {
                for (int j = k; j <= n; j++) {
                    int temp = pre[i][j] - pre[i-k][j] - pre[i][j-k] + pre[i-k][j-k];
                    max = Math.max(max, temp);
                }
            }
        }

        System.out.println(max);
    }
}
