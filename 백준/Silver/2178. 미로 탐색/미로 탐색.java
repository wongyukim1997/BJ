import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        visited = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            str = br.readLine();
            for(int j = 1; j <= m; j++){
                map[i][j] = Character.getNumericValue(str.charAt(j-1));
            }
        }

//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= m; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println("");
//        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));

        visited[1][1] = 1;

        while(!q.isEmpty()){
            Point temp = q.poll();

            if(temp.x == n && temp.y == m) break;

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx > 0 && ny > 0 && nx <= n && ny <= m && map[nx][ny] == 1 && visited[nx][ny] == 0){
                    visited[nx][ny] = visited[temp.x][temp.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }

        return visited[n][m];
    }
}
