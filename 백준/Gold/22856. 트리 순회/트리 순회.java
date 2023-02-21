    import java.awt.*;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    import java.util.List;

public class Main {

    static int n, cnt = 0;
    static int[][] arr;

    static boolean check = false;
    static boolean isRight = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);

        arr = new int[n+1][2];

        for(int i = 1; i <= n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int c = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[c][0] = a;
            arr[c][1] = b;
        }

//        for(int i = 1; i <= n; i++){
//            System.out.println(arr[i][0] + " " + arr[i][1]);
//        }

        dfs(1);

        System.out.println(cnt);
    }

    static void dfs(int num){
        if(num != 1) cnt++;
//        System.out.println(num + " 내려옴 " + cnt);
        if(num == n) check = true;

        if(arr[num][0] != -1) {
            dfs(arr[num][0]);
            cnt++;
//          System.out.println(num + " 올라옴 " + cnt);
        }

        if(num == 1) isRight = true;

        if(arr[num][1] != -1) {
            dfs(arr[num][1]);
            if(isRight) {
                if(!check) {
                    cnt++;
//                    System.out.println(num + " 올라옴 " + cnt);
                }
            }else {
                cnt++;
//                System.out.println(num + " 올라옴 " + cnt);
            }
        }
    }
}