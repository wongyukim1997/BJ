
import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];

        dfs(1, 1);
        System.out.println(cnt);
    }

    static void dfs(int x, int y){
        if(x == n && y == m+1){
            cnt++;
//            System.out.println();
//            for(int i = 1; i <= n; i++){
//                for(int j = 1; j <= m; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
            return;
        }

        for(int i = x; i <= n; i++){
            if(i != x) y = 1;
            for(int j = y; j <= m; j++){
                if(check(i, j)){
                    map[i][j] = 1;

                    dfs(i, j+1);

                    map[i][j] = 0;
                }
            }
        }

        cnt++;
//        System.out.println();
//        System.out.println("그냥 끝날 때");
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= m; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    static boolean check(int x, int y){
        if(map[x][y-1] == 1 && map[x-1][y] == 1 && map[x-1][y-1] == 1) return false;
        return true;
    }

}