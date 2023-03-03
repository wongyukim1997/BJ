
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, count = 0;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        n = 12;
        m = 6;

        map = new char[n][m];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        while (true) {
            visit = new boolean[n][m];
            boolean rerun = false;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] != '.' && !visit[i][j]) {
                        visit[i][j] = true;
                        boolean check = bfs(i, j, map[i][j]);
                        if(check) rerun = true;
                    }
                }
            }

            if(!rerun) break;
            count++;
            down();
            
//            System.out.println();
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < m; j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println(count);
        }

        System.out.println(count);
    }

    static boolean bfs(int x, int y, char c){
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y));
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;

        int cnt = 1;
        while(!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == c){
                    cnt++;
                    visit[nx][ny] = true;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }

        if(cnt >= 4){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(visited[i][j]) map[i][j] = '.';
                }
            }
            return true;
        }else{
            return false;
        }
    }

    static void down(){
        for(int i = 0; i < m; i++){
            for(int j = n-2; j >= 0; j--){
                if(map[j][i] != '.' && map[j+1][i] == '.'){
                    for(int k = j+1; k < n; k++){
                        if(map[k][i] != '.'){
                            char temp = map[j][i];
                            map[k-1][i] = temp;
                            map[j][i] = '.';
                            break;
                        }
                        else if(k == n-1){
                            char temp = map[j][i];
                            map[k][i] = temp;
                            map[j][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

}