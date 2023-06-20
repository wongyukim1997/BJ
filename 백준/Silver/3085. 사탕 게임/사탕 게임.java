
import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);
        map = new char[n][n];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
            }
        }

        // 사탕을 얼마나 먹을 수 있는지 체크
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                check(i, j);
            }
        }

//        System.out.println(max);

        // 각 자리를 다 바꿔보고 먹는 사탕 체크
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                changeAndCheck(i, j);
            }
        }

        System.out.println(max);
    }

    static void changeAndCheck(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                char temp = map[x][y];
                map[x][y] = map[nx][ny];
                map[nx][ny] = temp;

                check(x, y);

                map[nx][ny] = map[x][y];
                map[x][y] = temp;
            }
        }
    }

    static void check(int x, int y){
        int m = 0;
        char col = map[x][y];

        for(int i = x; i < n; i++) {
            if(col == map[i][y]) m++;
            else break;
        }
        for(int i = x; i >= 0; i--) {
            if(col == map[i][y]) m++;
            else break;
        }

        m -= 1;
        max = Math.max(max, m);

        m = 0;
        for(int i = y; i < n; i++) {
            if(col == map[x][i]) m++;
            else break;
        }
        for(int i = y; i >= 0; i--) {
            if(col == map[x][i]) m++;
            else break;
        }

        m -= 1;
        max = Math.max(max, m);


    }
}