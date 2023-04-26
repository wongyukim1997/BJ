import java.util.*;
import java.io.*;

public class Main {
    static int n, m, q, r1, r2, c1, c2;
    static int[][] map;
    static int[][] prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        prefix = new int[n+1][m+1];

        for(int i = 1; i < n+1; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j < m+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prefix[1][1] = map[1][1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] + map[i][j] - prefix[i-1][j-1];
            }
        }

//        System.out.println();
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= m; j++){
//                System.out.print(prefix[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int p = 0; p < q; p++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            int cnt = (r2-r1+1) * (c2-c1+1);

            sum = prefix[r2][c2] + prefix[r1-1][c1-1] - prefix[r1-1][c2] - prefix[r2][c1-1];

//            System.out.println(sum);
            sb.append(sum/cnt + "\n");
        }

        System.out.print(sb);
    }
}
