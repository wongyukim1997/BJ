
import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r, point = 0;
    static int[][] map;
    static char[][] result;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        result = new char[n+1][m+1];

        for(int i = 1; i <= n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j <= m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = 'S';
            }
        }

        for(int t = 0; t < r; t++){
            // 공격수

            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            int dir = 0;

            if(d == 'W') dir = 1;
            else if(d == 'S') dir = 2;
            else if(d == 'N') dir = 3;

            if(result[x][y] == 'S') {
                point++;
                attack(x, y, dir);
            }

            // 수비

            str = br.readLine();
            st = new StringTokenizer(str, " ");

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            result[x][y] = 'S';
        }

        System.out.println(point);
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void attack(int x, int y, int d){
        int len = map[x][y];
        result[x][y] = 'F';

        for(int i = 1; i < len; i++){
            int nx = dx[d]*i + x;
            int ny = dy[d]*i + y;

            if(nx > 0 && ny > 0 && nx <= n && ny <= m && result[nx][ny] == 'S') {
                point++;
                attack(nx, ny, d);
            }
        }
    }
}