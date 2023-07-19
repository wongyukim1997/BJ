
import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static int n, m;
    static int[][] map, next;
    static boolean[][] check;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        next = new int[n][m];


        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true){
            check = new boolean[n][m];

//            for(int i = 0; i < n; i++){
//				for(int j = 0; j < m; j++) System.out.print(map[i][j] + " ");
//				System.out.println();
//			}
//			System.out.println();

            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] != 0 && !check[i][j]){
                        check[i][j] = true;
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            if(cnt > 1) break;
            else if(cnt == 0) {
                year = 0;
                break;
            }

            year++;
            melt();
        }

        System.out.println(year);
    }

    static void melt(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] -= next[i][j];
                if(map[i][j] < 0) map[i][j] = 0;
            }
        }
    }

    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while(!q.isEmpty()){
            Point temp = q.poll();

            int cnt = 0;
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(map[nx][ny] != 0 && !check[nx][ny]){
                        check[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                    else if(map[nx][ny] == 0) cnt++;
                }
            }

            next[temp.x][temp.y] = cnt;
//            System.out.println(temp.x + ", " + temp.y + " : " + cnt);
        }
    }
}