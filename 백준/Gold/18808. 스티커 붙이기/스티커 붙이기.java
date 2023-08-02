
import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] map;

    static List<int[][]> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int h = 0; h < k; h++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[][] temp = new int[a][b];

            for(int i = 0; i < a; i++){
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                for(int j = 0; j < b; j++){
                    temp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            list.add(temp);
        }

//        스티커 확인
//        for(int i = 0; i < list.size(); i++){
//            System.out.println();
//            for(int k = 0; k < list.get(i).length; k++){
//                for(int j = 0; j < list.get(i)[0].length; j++){
//                    System.out.print(list.get(i)[k][j] + " ");
//                }
//                System.out.println();
//            }
//        }

        int cnt = 0;
        for(int num = 0; num < list.size(); num++){
            boolean check = false;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++) {
                    if(i + list.get(num).length <= n && j + list.get(num)[0].length <= m) {
                        check = stickerCheck(i, j, num);
                        if(check) {
                            cnt = 0;
                            break;
                        }
                    }
                }
                if(check) break;
            }

            if(!check){
                if(cnt < 3) {
                    cnt++;
                    turn(num);
                    num--;
                }
                else cnt = 0;
            }
        }

        int sticker = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1) sticker++;
//                System.out.print(map[i][j] + " ");
            }
//            System.out.println();
        }

        System.out.println(sticker);
    }

    static void turn(int num){
        int[][] target = list.get(num);
        int[][] temp = new int[target[0].length][target.length];

        for(int i = 0; i < target[0].length; i++){
            for(int j = 0; j < target.length; j++){
                temp[i][j] = target[target.length - 1 -j][i];
            }
        }

        list.set(num, temp);
        //        스티커 확인
//        for(int i = 0; i < list.size(); i++){
//            System.out.println();
//            for(int k = 0; k < list.get(i).length; k++){
//                for(int j = 0; j < list.get(i)[0].length; j++){
//                    System.out.print(list.get(i)[k][j] + " ");
//                }
//                System.out.println();
//            }
//        }
    }

    static boolean stickerCheck(int x, int y, int num){
        int[][] temp = list.get(num);
        int sx = temp.length;
        int sy = temp[0].length;

//        if(num == 1) System.out.println(num + " " + x + " " + y);

        for(int i = x; i < x+sx; i++){
            for(int j = y; j < y+sy; j++){
                if(temp[i - x][j - y] == 1 && map[i][j] == 1) return false;
            }
        }

        for(int i = x; i < x+sx; i++){
            for(int j = y; j < y+sy; j++){
                if(temp[i - x][j - y] == 1) map[i][j] = 1;
            }
        }

        return true;
    }

}