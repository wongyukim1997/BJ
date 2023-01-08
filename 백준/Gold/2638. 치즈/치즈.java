
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while(true) {
            cnt++;
            checkAir();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 2){
                        melting(i, j);
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 2){
                        map[i][j] = 1;
                    }
                    else if(map[i][j] == 3) {
                        map[i][j] = 0;
                    }
                }
            }

            if(!checkCheese()) break;
        }

        System.out.println(cnt);
    }

    static void melting(int x, int y) {
        int cnt = 0;
        for(int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];

            if(map[nx][ny] == 3) {
                cnt++;
            }
        }

        if(cnt >= 2) map[x][y] = 0;
    }

    static boolean checkCheese() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) return true;
            }
        }

        return false;
    }

    //새로 나온 공기 확인 BFS
    static void checkAir() {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0, 0));
        map[0][0] = 3;

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = 3;
                        q.add(new Point(nx, ny));
                    }
                    else if(map[nx][ny] == 1) {
                        map[nx][ny] = 2;
                    }
                }
            }
        }

    }

}