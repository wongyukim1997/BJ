import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {

    static int[][] idx = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static boolean[][] check;
    static int T, n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        T = Integer.parseInt(str);

        for(int t = 0; t < T; t++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            check = new boolean[n][m];
            int cnt = 0;

            for(int i = 0; i < k; i++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[b][a] = 1;
            }

            for(int i = 0; i < n; i++) {
                for(int j =0; j < m; j++) {
                    if(map[i][j] == 1 && !check[i][j]){
                        BFS(new Point(i, j));
                        cnt++;
                    }

                }
            }

            System.out.println(cnt);
        }

    }

    public static void BFS(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i = 0; i < 4; i++) {
                int tx = temp.x + idx[i][0];
                int ty = temp.y + idx[i][1];

                if(tx >= 0 && ty >= 00 && tx < n && ty < m && map[tx][ty] == 1 && !check[tx][ty]) {
                    check[tx][ty] = true;
                    q.offer(new Point(tx, ty));
                }
            }
        }

    }
}
