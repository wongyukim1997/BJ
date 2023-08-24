
import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static class Snake{
        int x, y, nx, ny;
        public Snake(int x, int y, int nx, int ny){
            this.x = x;
            this.y = y;
            this.nx = nx;
            this.ny = ny;
        }
    }
    static class Command{
        int x;
        char c;
        public Command(int x, char c){
            this.x = x;
            this.c = c;
        }
    }
    static int n, k, l;
    static int[][] map;
    static Command[] commands;
    static Snake snake = new Snake(1, 1, 0, 1);
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);
        map = new int[n+1][n+1];

        str = br.readLine();
        k = Integer.parseInt(str);
        StringTokenizer st;

        for(int i = 0; i < k; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 2;
        }

        str = br.readLine();
        l = Integer.parseInt(str);
        commands = new Command[l];

        for(int i = 0; i < l; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            commands[i] = new Command(x, c);
        }

        int cnt = 1;
        int cntCommand = 0;
        q.add(new Point(1, 1));

        while(move()){
//            if(!move()) break;

            if(cntCommand < l && commands[cntCommand].x == cnt){
                turn(commands[cntCommand].c);
                cntCommand++;
            }

            cnt++;
        }

        System.out.println(cnt);
    }

    static boolean move(){
        int nx = snake.x + snake.nx;
        int ny = snake.y + snake.ny;

//        System.out.println(nx + " " + ny);

        if(nx > 0 && ny > 0 && nx <= n && ny <= n && (map[nx][ny] == 0 || map[nx][ny] == 2)){
            if (map[snake.x + snake.nx][snake.y + snake.ny] == 0) {
                Point temp = q.poll();
                map[temp.x][temp.y] = 0;
            }

            map[nx][ny] = 1;
            snake.x = nx;
            snake.y = ny;
            q.add(new Point(nx, ny));

            return true;
        }
        else return false;
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