
import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map, copy;
    static boolean[][] check;
    static int sum;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    static class BlockGroup implements Comparable<BlockGroup>{
        int minX, minY, rainbow, c, cnt;
        public BlockGroup(int minX, int minY, int rainbow, int c, int cnt){
            this.minX = minX;
            this.minY = minY;
            this.rainbow = rainbow;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(BlockGroup o) {
            if(this.cnt == o.cnt){
                if(this.rainbow == o.rainbow){
                    if(this.minX == o.minX) return o.minY - this.minY;
                    return o.minX - this.minX;
                }
                return o.rainbow - this.rainbow;
            }
            return o.cnt - this.cnt;
        }
    }

    static List<BlockGroup> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        copy = new int[n][n];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            boolean isGroup = false;
            int big = 0;
            int c = 1;

            check = new boolean[n][n];
            list = new ArrayList<>();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!check[i][j] && map[i][j] != -1 && map[i][j] != 0 && map[i][j] != -2){
                        check[i][j] = true;
                        int cnt = findBig(i, j, c);
                        if(cnt != 1) isGroup = true;

                        c++;
                    }
                }
            }

            if(!isGroup) break;

//            System.out.println();
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++){
//                    System.out.print(check[i][j] + " ");
//                }
//                System.out.println();
//            }

            Collections.sort(list);

//            System.out.println();
//            for(BlockGroup b : list){
//                System.out.print(b.c + " ");
//            }

//            System.out.println("  x : " + list.get(0).minX +  ", y : " + list.get(0).minY);
            delete(list.get(0).minX, list.get(0).minY);
            sum += Math.pow(list.get(0).cnt, 2);

//            System.out.println();
//            System.out.println("지운거");
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            gravity();

//            System.out.println();
//            System.out.println("내린거 1");
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            copyMap();
            turn();

//            System.out.println();
//            System.out.println("돌린거");
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            gravity();

//            System.out.println();
//            System.out.println("내린거 2");
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//
//            System.out.println("포인트 : " + sum + ", 이번건 :" + Math.pow(list.get(0).cnt, 2));
        }

        System.out.println(sum);
    }

    // 회전하자.....
    static void turn(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = copy[j][n-i-1];
            }
        }

    }

    // 카피하자..
    static void copyMap(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                copy[i][j] = map[i][j];
            }
        }
    }

    // 중력을 느껴라...
    static void gravity(){
        for(int i = 0; i < n; i++){
            for(int j = n-2; j >= 0; j--){
                if(map[j][i] == -2 || map[j][i] == -1) continue;

                int num = map[j][i];
                map[j][i] = -2;

                for(int k = j; k < n; k++){
                    if(map[k][i] != -2){
                        map[k-1][i] = num;
                        break;
                    }
                    else if(k == n-1 && map[k][i] == -2) map[k][i] = num;
                }
            }
        }
    }

    // 지우자....
    static void delete(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        int num = map[x][y];
        map[x][y] = -2;

        while(!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && (map[nx][ny] == num || map[nx][ny] == 0)){
                    map[nx][ny] = -2;
                    q.add(new Point(nx, ny));
                }
            }
        }

    }

    // 우선 찾자 큰 그룹..
    static int findBig(int x, int y, int c){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        int num = map[x][y];
        boolean[][] thisCheck = new boolean[n][n];
        thisCheck[x][y] = true;

        int minX = x;
        int minY = y;
        int rainbow = 0;

        int cnt = 1;
        while(!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !check[nx][ny] && !thisCheck[nx][ny] && (map[nx][ny] == num || map[nx][ny] == 0)){
                    cnt++;
                    q.add(new Point(nx, ny));
                    thisCheck[nx][ny] = true;

                    if(map[nx][ny] != 0){
                        check[nx][ny] = true;

                        if(minX >= nx){
                            if(minX == nx){
                                if(minY > ny) minY = ny;
                            }
                            else{
                                minX = nx;
                                minY = ny;
                            }
                        }
                    }
                    else rainbow++;
                }
            }
        }

        if(cnt != 1) list.add(new BlockGroup(minX, minY, rainbow, c, cnt));
        return cnt;
    }
}