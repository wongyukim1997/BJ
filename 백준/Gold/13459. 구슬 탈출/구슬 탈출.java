
import java.io.*;
import java.util.*;

public class Main {
    static class Marble{
        int rx, ry, bx, by;

        public Marble(int rx, int ry, int bx, int by){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }
    static class Turn {
        int x, y, dist;

        public Turn(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int n, m;
    static char[][] map;
    static boolean[][][][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static Marble marble;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m][n][m];

        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;

        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                else if(map[i][j] == 'B'){
                    bx = i;
                    by = j;
                }
            }
        }

        marble = new Marble(rx, ry, bx, by);

        int res = bfs();

        if(res != 0) System.out.println(1);
        else System.out.println(res);
    }

    static int bfs(){
        Queue<Marble> q = new LinkedList<>();
        q.add(marble);

        visit[marble.rx][marble.ry][marble.bx][marble.by] = true;

        int cnt = 1;
        while(!q.isEmpty()){
            int len = q.size();

            if(cnt > 10) return 0;

            cnt++;
            for(int l = 0; l < len; l++){
                Marble temp = q.poll();

                for(int i = 0; i < 4; i++) {
                    Turn red = move(temp.rx, temp.ry, 0, i);
                    Turn blue = move(temp.bx, temp.by, 0, i);

                    if(map[blue.x][blue.y] == 'O') continue;
                    if(map[red.x][red.y] == 'O') return cnt;

                    // 이부분이 필요했음
                    if (red.x == blue.x && red.y == blue.y) {
                        // 빨간 구슬이 더 많이 이동했을 경우
                        if(red.dist > blue.dist) {
                            // 이전 위치로
                            red.x -= dx[i];
                            red.y -= dy[i];
                        } else {
                            blue.x -= dx[i];
                            blue.y -= dy[i];
                        }
                    }


                    // 4차원으로 표시해야 훨씬 편했음
                    if(visit[red.x][red.y][blue.x][blue.y]) continue;
                    visit[red.x][red.y][blue.x][blue.y] = true;

                    q.add(new Marble(red.x, red.y, blue.x, blue.y));
                }
            }
        }

        return 0;
    }

    static Turn move(int x, int y, int dist, int d){
        int nx = x;
        int ny = y;

//        System.out.println(nx + " " + ny);

        while(map[nx + dx[d]][ny + dy[d]] != '#' && map[nx][ny] != 'O') {
            nx += dx[d];
            ny += dy[d];
            dist++;
        }

        return new Turn(nx, ny, dist);
    }
}