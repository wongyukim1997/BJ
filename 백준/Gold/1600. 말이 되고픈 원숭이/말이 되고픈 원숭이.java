
import java.util.*;
import java.io.*;

public class Main {
    static int k, n, m;
    static int[][] map;
    static boolean[][][] visit;
    static int[] sx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] sy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    static class Monkey{
        int x, y, s, c;
        public Monkey(int x, int y, int s, int c){
            this.x = x;
            this.y = y;
            this.s = s;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        k = Integer.parseInt(str);

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean [k+1][n][m];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = bfs();
        System.out.println(res);
    }

    static int bfs(){
        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, 0, 0));
        
        while(!q.isEmpty()){
            Monkey temp = q.poll();

            if(temp.x == n-1 && temp.y == m-1) return temp.c;

            for(int i = 0; i < 8; i++){
                int nx = sx[i] + temp.x;
                int ny = sy[i] + temp.y;

                if(temp.s >= k) break;
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 1 && !visit[temp.s+1][nx][ny]){
                    visit[temp.s+1][nx][ny] = true;
                    q.add(new Monkey(nx, ny, temp.s+1, temp.c+1));
                }
            }

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 1 && !visit[temp.s][nx][ny]){
                    visit[temp.s][nx][ny] = true;
                    q.add(new Monkey(nx, ny, temp.s, temp.c+1));
                }
            }
        }

        return -1;
    }
}