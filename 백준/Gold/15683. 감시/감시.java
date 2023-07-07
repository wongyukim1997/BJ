
import java.util.*;
import java.io.*;

public class Main {
    static class Camera{
        int x, y, t;
        public Camera(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    static int n, m, min = Integer.MAX_VALUE;
    static int[][] map;
    static List<Camera> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6) list.add(new Camera(i, j, map[i][j]));
            }
        }

        dfs(0, map);
        System.out.println(min);
    }

    static void dfs(int num, int[][] copy){
        if(num == list.size()){
            check(copy);
            return;
        }

        Camera c = list.get(num);

        if(c.t == 1){
            for(int i = 0; i < 4; i++){
                int[][] temp = new int[n][m];
                copyMap(copy, temp);

                see(c.x, c.y, i, temp);

                dfs(num+1, temp);
            }
        }
        else if(c.t == 2){
            for(int i = 0; i < 2; i++){
                int[][] temp = new int[n][m];
                copyMap(copy, temp);

                if(i == 0) {
                    see(c.x, c.y, 0, temp);
                    see(c.x, c.y, 1, temp);
                }
                else{
                    see(c.x, c.y, 2, temp);
                    see(c.x, c.y, 3, temp);
                }

                dfs(num + 1, temp);
            }
        }
        else if(c.t == 3){
            for(int i = 0; i < 4; i++){
                int[][] temp = new int[n][m];
                copyMap(copy, temp);

                int d = i+2;
                if(d == 4) d = 1;
                else if(d == 5) d = 0;
                see(c.x, c.y, i, temp);
                see(c.x, c.y, d, temp);

                dfs(num+1, temp);
            }
        }
        else if(c.t == 4){
            for(int i = 0; i < 4; i++){
                int[][] temp = new int[n][m];
                copyMap(copy, temp);

                for(int j = 0; j < 4; j++) {
                    if(j == i) continue;
                    see(c.x, c.y, j, temp);
                }

                dfs(num+1, temp);
            }
        }
        else{
            int[][] temp = new int[n][m];
            copyMap(copy, temp);

            for(int i = 0; i < 4; i++) see(c.x, c.y, i, temp);

            dfs(num+1, temp);
        }
    }

    static void copyMap(int[][] a, int[][] b){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                b[i][j] = a[i][j];
            }
        }
    }

    static void check(int[][] copy){
        int cnt = 0;
//        System.out.println();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
//                System.out.print(copy[i][j] + " ");
                if(copy[i][j] == 0) cnt++;
            }
//            System.out.println();
        }

        min = Math.min(min, cnt);
    }

    static void see(int x, int y, int d, int[][] temp){
        if(d == 0){
            for(int i = x+1; i < n; i++){
                if(temp[i][y] == 6) break;
                temp[i][y] = 7;
            }
        }
        else if(d == 1){
            for(int i = x-1; i >= 0; i--){
                if(temp[i][y] == 6) break;
                temp[i][y] = 7;
            }
        }
        else if(d == 2){
            for(int i = y+1; i < m; i++){
                if(temp[x][i] == 6) break;
                temp[x][i] = 7;
            }
        }else{
            for(int i = y-1; i >= 0; i--){
                if(temp[x][i] == 6) break;
                temp[x][i] = 7;
            }
        }
    }

}