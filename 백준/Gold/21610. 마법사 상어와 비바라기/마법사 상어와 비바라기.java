
import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] order;
    static boolean[][] cloud;
    static Queue<Point> clouds = new LinkedList<>();

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        order = new int[m][2];


        for(int i = 1; i <= n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }

        clouds.add(new Point(n, 1));
        clouds.add(new Point(n, 2));
        clouds.add(new Point(n-1, 1));
        clouds.add(new Point(n-1, 2));

        for(int i = 0; i < m; i++){
//            System.out.println();
//            for(int k = 1; k <= n; k++){
//                for(int j = 1; j <= n; j++){
//                    System.out.print(map[k][j] + " ");
//                }
//                System.out.println();
//            }

            cloud = new boolean[n+1][n+1];

            moveCloud(order[i][0]-1, order[i][1]);
            copyWater();
            makeCloud();
        }

        int sum = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    // 구름을 만들어
    static void makeCloud(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(!cloud[i][j] && map[i][j] >= 2){
                    map[i][j] -= 2;
                    clouds.add(new Point(i, j));
                }
            }
        }
    }

    // 구름아 움직여
    static void moveCloud(int d, int s){
        int size = clouds.size();

        for(int i = 0; i < size; i++){
            Point temp = clouds.poll();

            int nx = temp.x;
            int ny = temp.y;

            for(int j = 0; j < s; j++){
                nx = nx + dx[d];
                ny = ny + dy[d];

                if(nx < 1) nx = n;
                else if(nx > n) nx = 1;
                if(ny < 1) ny = n;
                else if(ny > n) ny = 1;
            }

            clouds.add(new Point(nx, ny));
            cloud[nx][ny] = true;
            map[nx][ny]++;
        }
    }

    // 물복사 버그
    static void copyWater(){
        int size = clouds.size();

        for(int i = 0; i < size; i++){
            Point temp = clouds.poll();

            for(int j = 1; j < 8; j += 2){
                int nx = temp.x + dx[j];
                int ny = temp.y + dy[j];

                if(nx >= 1 && ny >= 1 && nx <= n && ny <= n && map[nx][ny] > 0){
                    map[temp.x][temp.y]++;
                }
            }
        }
    }

}