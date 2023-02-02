import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st ;

        n = Integer.parseInt(str);

        arr = new int[n][3];
        int[][] dp1 = new int[n][3];
        int[][] dp2 = new int[n][3];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp1[0][0] = arr[0][0];
        dp1[0][1] = arr[0][1];
        dp1[0][2] = arr[0][2];

        dp2[0][0] = arr[0][0];
        dp2[0][1] = arr[0][1];
        dp2[0][2] = arr[0][2];

        for(int i = 1; i < n; i++){
            dp1[i][0] = arr[i][0] + Math.max(dp1[i-1][0], dp1[i-1][1]);
            dp1[i][1] = arr[i][1] + Math.max(dp1[i-1][2], Math.max(dp1[i-1][0], dp1[i-1][1]));
            dp1[i][2] = arr[i][2] + Math.max(dp1[i-1][2], dp1[i-1][1]);

            dp2[i][0] = arr[i][0] + Math.min(dp2[i-1][0], dp2[i-1][1]);
            dp2[i][1] = arr[i][1] + Math.min(dp2[i-1][2], Math.min(dp2[i-1][0], dp2[i-1][1]));
            dp2[i][2] = arr[i][2] + Math.min(dp2[i-1][2], dp2[i-1][1]);
        }

        int max = Math.max(dp1[n-1][0], Math.max(dp1[n-1][1], dp1[n-1][2]));
        int min = Math.min(dp2[n-1][0], Math.min(dp2[n-1][1], dp2[n-1][2]));

//        for(int i = 0; i < n; i++){
//            System.out.println(dp2[i][0] + " " + dp2[i][1] + " " + dp2[i][2]);
//        }
        System.out.println(max + " " + min);
    }
}