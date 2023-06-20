
import java.io.*;
import java.util.*;

public class Main {
    static class Robot{
        int x, y, d;
        public Robot(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int n, m;
    static int[][] map;
    static Robot robot;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 0 : 북, 1 : 동, 2 : 남, 3 : 서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        robot = new Robot(x, y, d);

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;

        while(true){
            if(map[robot.x][robot.y] == 0) {
                sum++;
                map[robot.x][robot.y] = 2;
            }
            boolean check = false;
//            System.out.println(robot.x + " " + robot.y + " : " + map[robot.x][robot.y]);
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + robot.x;
                int ny = dy[i] + robot.y;

                if(map[nx][ny] == 0) check = true;
            }

            if(!check){
                goBack();
                if(map[robot.x][robot.y] == 1) {
//                    System.out.println(robot.x + " " + robot.y + " : " + map[robot.x][robot.y]);
                    break;
                }
            } else{
                while(true){
                    boolean go = turn();

                    if(go){
                        robot.x += dx[robot.d];
                        robot.y += dy[robot.d];
                        break;
                    }
                }
            }
        }

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(sum);
    }

    static boolean turn(){
        if(robot.d == 0) robot.d = 3;
        else if (robot.d == 1) robot.d = 0;
        else if (robot.d == 2) robot.d = 1;
        else robot.d = 2;

        int nx = robot.x + dx[robot.d];
        int ny = robot.y + dy[robot.d];

        if(map[nx][ny] == 0) return true;
        else return false;
    }

    static void goBack(){
        if(robot.d == 0){
            robot.x += dx[2];
            robot.y += dy[2];
        }
        else if(robot.d == 1){
            robot.x += dx[3];
            robot.y += dy[3];
        }
        else if(robot.d == 2){
            robot.x += dx[0];
            robot.y += dy[0];
        }
        else if(robot.d == 3){
            robot.x += dx[1];
            robot.y += dy[1];
        }
    }
}