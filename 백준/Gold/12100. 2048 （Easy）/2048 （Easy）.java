
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, max = 0, c = 0;
    static int[][] map, copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        com(0, new int[5]);
        System.out.println(max);
    }

    static void com(int cnt, int[] arr){
        if(cnt == 5){
            move(arr);
            return;
        }

        for(int i = 0; i < 4; i++){
            arr[cnt] = i;
            com(cnt+1, arr);
        }
    }

    static void initCopy(){
        copy = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                copy[i][j] = map[i][j];
            }
        }
    }

    static void move(int[] arr){
        initCopy();

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                System.out.print(copy[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < 5; i++){
            if(arr[i] == 0){
                copy = sumUp(copy);
            }else if(arr[i] == 1){
                copy = sumDown(copy);
            }else if(arr[i] == 2){
                copy = sumLeft(copy);
            }else if(arr[i] == 3){
                copy = sumRight(copy);
            }
        }

        max = Math.max(max, findMax(copy));
    }

    //위로 합칠 경우
    static int[][] sumUp(int[][] map){
        boolean[][] visit = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[j][i] != 0){
                    for(int k = j-1; k >= 0; k--){
                        if(map[k][i] != 0 && !visit[k][i] && map[k][i] == map[j][i]){
//                            System.out.println(1);
                            map[k][i] = map[k][i] * 2;
                            map[j][i] = 0;
                            visit[k][i] = true;
                            break;
                        }
                        else if(map[k][i] != 0 && visit[k][i]) {
//                            System.out.println(2);
                            int temp = map[j][i];
                            map[k+1][i] = temp;
                            map[j][i] = 0;
                            break;
                        }
                        else if(map[k][i] != 0 && map[k][i] != map[j][i]){
//                            System.out.println(3);
                            int temp = map[j][i];
                            map[j][i] = 0;
                            map[k+1][i] = temp;
                            break;
                        }
                        else if(k == 0 && map[k][i] == 0){
//                            System.out.println(4);
                            map[k][i] = map[j][i];
                            map[j][i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return map;
    }

    //아래로 합칠 경우
    static int[][] sumDown(int[][] map){
        boolean[][] visit = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = n-1; j >= 0; j--){
                if(map[j][i] != 0){
                    for(int k = j+1; k < n; k++){
                        if(map[k][i] != 0 && !visit[k][i] && map[k][i] == map[j][i]){
//                            System.out.println(1);
                            map[k][i] = map[k][i] * 2;
                            map[j][i] = 0;
                            visit[k][i] = true;
                            break;
                        }
                        else if(map[k][i] != 0 && visit[k][i]) {
//                            System.out.println(2);
                            int temp = map[j][i];
                            map[k-1][i] = temp;
                            map[j][i] = 0;
                            break;
                        }
                        else if(map[k][i] != 0 && map[k][i] != map[j][i]){
//                            System.out.println(3);
                            int temp = map[j][i];
                            map[j][i] = 0;
                            map[k-1][i] = temp;
                            break;
                        }
                        else if(k == n-1 && map[k][i] == 0){
//                            System.out.println(4);
                            map[k][i] = map[j][i];
                            map[j][i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return map;
    }

    //왼쪽으로 합칠 경우
    static int[][] sumLeft(int[][] map){
        boolean[][] visit = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] != 0){
                    for(int k = j-1; k >= 0; k--){
                        if(map[i][k] != 0 && !visit[i][k] && map[i][k] == map[i][j]){
//                            System.out.println(1);
                            map[i][k] = map[i][k] * 2;
                            map[i][j] = 0;
                            visit[i][k] = true;
                            break;
                        }
                        else if(map[i][k] != 0 && visit[i][k]) {
//                            System.out.println(2);
                            int temp = map[i][j];
                            map[i][k+1] = temp;
                            map[i][j] = 0;
                            break;
                        }
                        else if(map[i][k] != 0 && map[i][k] != map[i][j]){
//                            System.out.println(3);
                            int temp = map[i][j];
                            map[i][j] = 0;
                            map[i][k+1] = temp;
                            break;
                        }
                        else if(k == 0 && map[i][k] == 0){
//                            System.out.println(4);
                            map[i][k] = map[i][j];
                            map[i][j] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return map;
    }

    //오른쪽으로 합칠 경우
    static int[][] sumRight(int[][] map){
        boolean[][] visit = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = n-1; j >= 0; j--){
                if(map[i][j] != 0){
                    for(int k = j+1; k < n; k++){
                        if(map[i][k] != 0 && !visit[i][k] && map[i][k] == map[i][j]){
//                            System.out.println(1);
                            map[i][k] = map[i][k] * 2;
                            map[i][j] = 0;
                            visit[i][k] = true;
                            break;
                        }
                        else if(map[i][k] != 0 && visit[i][k]) {
//                            System.out.println(2);
                            int temp = map[i][j];
                            map[i][k-1] = temp;
                            map[i][j] = 0;
                            break;
                        }
                        else if(map[i][k] != 0 && map[i][k] != map[i][j]){
//                            System.out.println(3);
                            int temp = map[i][j];
                            map[i][j] = 0;
                            map[i][k-1] = temp;
                            break;
                        }
                        else if(k == n-1 && map[i][k] == 0){
//                            System.out.println(4);
                            map[i][k] = map[i][j];
                            map[i][j] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return map;
    }

    static int findMax(int[][] copy){
        int m = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
//                System.out.print(copy[i][j] + " ");
                m = Math.max(copy[i][j], m);
            }
//            System.out.println();
        }

        return m;
    }

}