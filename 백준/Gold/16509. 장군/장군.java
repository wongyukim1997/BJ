
import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static int s1, s2;
    static int k1, k2;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] zx = {-1, -1, -1, 1, 1, 1, 1, -1};
    static int[] zy = {-1, 1, 1, 1, 1, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        s1 = Integer.parseInt(st.nextToken());
        s2 = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        k1 = Integer.parseInt(st.nextToken());
        k2 = Integer.parseInt(st.nextToken());

        map = new int[10][9];

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(s1, s2));

        map[s1][s2] = 1;

        while(!q.isEmpty()){
            Point temp = q.poll();

            if(temp.x == k1 && temp.y == k2) return map[temp.x][temp.y] - 1;

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;

                if(nx == k1 && ny == k2) continue;

//                System.out.println();
//                System.out.println(nx + " " + ny);

                for(int j = 0; j < 2; j++){

                    int m = i * 2 + j;

                    int mx = nx + zx[m];
                    int my = ny + zy[m];

                    if(mx == k1 && my == k2) continue;

//                    System.out.println(mx + " " + my);

                    mx += zx[m];
                    my += zy[m];

                    if(mx >= 0 && my >= 0 && mx < 10 && my < 9 && map[mx][my] == 0){
//                        System.out.println(mx + " " + my);
                        map[mx][my] = map[temp.x][temp.y] + 1;
                        q.add(new Point(mx, my));
                    }
                }
            }
        }

        return -1;
    }

}