import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.List;

public class Main {
    // 꼬리와 머리를 따로 보거나 아니면 한칸한칸에 객체로 넣어주면 될듯? 헤더랑 꼬리만 따로 체크하고!
    static class Snake{     // nx ny 를 통해서 방향 설정
        int x, y, nx, ny;
        public Snake(int x, int y, int nx, int ny){
            this.x = x;
            this.y = y;
            this.nx = nx;
            this.ny = ny;
        }
    }
    static class Dis{
        int x;
        char c;
        public Dis(int x, char c){
            this.x = x;
            this.c = c;
        }
    }
    static int n, k, l;
    static int[][] map;
    static Dis[] dis;
    static Snake snake = new Snake(0, 0, 0, 1);
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);
        map = new int[n][n];
        map[0][0] = 1;
        q.add(new Point(0, 0));

        str = br.readLine();
        k = Integer.parseInt(str);

        for(int i = 0; i < k; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a-1][b-1] = 2;
        }

        str = br.readLine();
        l = Integer.parseInt(str);
        dis = new Dis[l];

        for(int i = 0; i < l; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            dis[i] = new Dis(x, c);
        }

        int cnt = 0;
        int cntDis = 0;

        while(true){
            // 먼저 초를 더한다
            cnt++;

            // 뱀의 머리가 움직인다.
            int nx = snake.x + snake.nx;
            int ny = snake.y + snake.ny;
            if(nx >= 0 && ny >= 0 && nx < n && ny < n && (map[nx][ny] == 0 || map[nx][ny] == 2)){
                // 움직인 곳에 사과가 없으면 꼬리도 이동한다
                if (map[snake.x + snake.nx][snake.y + snake.ny] == 0) {
                    Point temp = q.poll();
                    map[temp.x][temp.y] = 0;
                }
                // 뱀의 머리 이동
                map[nx][ny] = 1;
                snake.x = nx;
                snake.y = ny;
                q.add(new Point(nx, ny));
            }else { // 머리가 야외거나 자신의 몸이라면 죽어야 함
                break;
            }

            // 만약 이동한 시간이 끝날 때 방향을 바꿔야 한다면
            if(cntDis < l && dis[cntDis].x == cnt){
                turn(dis[cntDis].c);
                cntDis++;
            }

//            System.out.println();
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
        }

        System.out.println(cnt);
    }

    static void turn(char c){
        if(snake.nx == 1 && snake.ny == 0){
            if(c == 'D'){
                snake.nx = 0;
                snake.ny = -1;
            }else{
                snake.nx = 0;
                snake.ny = 1;
            }
        }else if(snake.nx == 0 && snake.ny == 1){
            if(c == 'D'){
                snake.nx = 1;
                snake.ny = 0;
            }else{
                snake.nx = -1;
                snake.ny = 0;
            }
        }else if(snake.nx == -1 && snake.ny == 0){
            if(c == 'D'){
                snake.nx = 0;
                snake.ny = 1;
            }else{
                snake.nx = 0;
                snake.ny = -1;
            }
        }else if(snake.nx == 0 && snake.ny == -1){
            if(c == 'D'){
                snake.nx = -1;
                snake.ny = 0;
            }else{
                snake.nx = 1;
                snake.ny = 0;
            }
        }
    }
}

