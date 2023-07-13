
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static int n, m, cnt = 0;
    static int[][] map;
    static boolean[][] check;
    static List<Point> airCon = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m;  j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) airCon.add(new Point(i, j));
            }
        }

        for(Point p : airCon){
            check[p.x][p.y] = true;

            for(int i = 0; i < 4; i++) go(p.x, p.y, i, p.x, p.y);
        }

        checkArea();
        System.out.println(cnt);
    }

    static void go(int x, int y, int d, int startX, int startY){
        int nx = x;
        int ny = y;

        while(true){
            nx = x + dx[d];
            ny = y + dy[d];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                x = nx;
                y = ny;

                check[x][y] = true;
                if(map[x][y] != 0 && map[x][y] != 9) {
                    turn(x, y, map[x][y], d, startX, startY);
                    return;
                }
                else if(x == startX && y == startY) return;
            }
            else return;
        }
    }

    static void turn(int x, int y, int type, int d, int startX, int startY){
        if(type == 1){
            if(d == 0) d = 1;
            else if(d == 1) d = 0;
        }
        else if(type == 2){
            if(d == 2) d = 3;
            else if(d == 3) d = 2;
        }
        else if(type == 3){
            if(d == 0) d = 2;
            else if(d == 1) d = 3;
            else if(d == 2) d = 0;
            else if(d == 3) d = 1;
        }
        else{
            if(d == 0) d = 3;
            else if(d == 1) d = 2;
            else if(d == 2) d = 1;
            else if(d == 3) d = 0;
        }

        go(x, y, d, startX, startY);
    }

    static void checkArea(){
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(check[i][j]) cnt++;
            }
        }
    }
}