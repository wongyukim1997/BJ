
import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static int n, m, q, k, p;
    static int[][] map;

    static int[] kx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] ky = {1, 2, 2, 1, -1, -2, -2 ,-1};

    static List<Point> qList = new ArrayList<>();
    static List<Point> kList = new ArrayList<>();
    static List<Point> pList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        q = Integer.parseInt(st.nextToken());
        for(int i = 0; i < q; i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;

            qList.add(new Point(x, y));
        }

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;

            kList.add(new Point(x, y));
        }

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        p = Integer.parseInt(st.nextToken());
        for(int i = 0; i < p; i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;

            pList.add(new Point(x, y));
        }

        for(Point p : kList){
            for(int i = 0; i < 8; i++){
                int nx = p.x + kx[i];
                int ny = p.y + ky[i];

                if(nx > 0 && ny > 0 && nx <= n && ny <= m && map[nx][ny] == 0) map[nx][ny] = 2;
            }
        }

        for(Point p : qList){
            for(int i = p.x + 1; i <= n; i++){
                if(map[i][p.y] == 1) break;
                map[i][p.y] = 2;
            }
            for(int i = p.x - 1; i > 0; i--){
                if(map[i][p.y] == 1) break;
                map[i][p.y] = 2;
            }
            for(int i = p.y + 1; i <= m; i++){
                if(map[p.x][i] == 1) break;
                map[p.x][i] = 2;
            }
            for(int i = p.y - 1; i > 0; i--){
                if(map[p.x][i] == 1) break;
                map[p.x][i] = 2;
            }

            for(int i = p.x + 1, j = p.y + 1; i <= n && j <= m; i++, j++) {
                if (map[i][j] == 1) break;
                map[i][j] = 2;
            }
            for(int i = p.x - 1, j = p.y + 1; i > 0 && j <= m; i--, j++){
                if(map[i][j] == 1) break;
                map[i][j] = 2;
            }
            for(int i = p.x + 1, j = p.y - 1; i <= n && j > 0; i++, j--){
                if(map[i][j] == 1) break;
                map[i][j] = 2;
            }
            for(int i = p.x - 1, j = p.y - 1; i > 0 && j > 0; i--, j--){
                if(map[i][j] == 1) break;
                map[i][j] = 2;
            }
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] == 0) cnt++;
            }
        }

        System.out.println(cnt);
    }
}