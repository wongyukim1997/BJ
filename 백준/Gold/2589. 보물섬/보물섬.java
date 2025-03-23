import java.util.*;
import java.awt.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[][] check;
    static int[][] idx = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int max = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i = 0; i < n; i++) {
            str = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'L') {
                    int temp = BFS(i, j);
                    if(max < temp) {
                        max = temp;
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static int BFS (int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        int cnt = 1;

        check = new int[n][m];
        check[x][y] = 1;

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i = 0; i < 4; i++) {
                int tx = temp.x + idx[i][0];
                int ty = temp.y + idx[i][1];

                if(tx < n && ty < m && tx >= 0 && ty >= 0 && map[tx][ty] == 'L' && check[tx][ty] == 0) {
                    check[tx][ty] = 1 + check[temp.x][temp.y];
                    q.offer(new Point(tx, ty));
                    if(cnt < check[tx][ty]) {
                        cnt = check[tx][ty];
                    }
                }
            }
        }

        return cnt-1;
    }
}
