
import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);
        map = new int[n][n];
        check = new boolean[n][n];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1){
                    map[i][j] = cnt;
                    bfs1(i, j, cnt);
                    cnt++;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] != 0){
                    int res = bfs2(i, j, map[i][j]);
                    if(res == -1) continue;

                    min = Math.min(min, res);
                }
            }
        }

        System.out.println(min);
    }

    static void bfs1(int x, int y, int num){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while(!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 1){
                    map[nx][ny] = num;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    static int bfs2(int x, int y, int num){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        check = new boolean[n][n];

        int cnt = 0;
        while(!q.isEmpty()){
            int len = q.size();

            for(int l = 0; l < len; l++) {
                Point temp = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !check[nx][ny] && map[nx][ny] != num) {
                        if(map[nx][ny] == 0) {
                            check[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                        else {
//                            System.out.println(nx + " " + ny + " : " + map[nx][ny]);
//                            System.out.println(num + " : " + cnt);
                            return cnt;
                        }
                    }
                }
            }

            cnt++;
        }

//        System.out.println("이런거 있음? " + x + " " + y + " : " + cnt);
        return -1;
    }
}