import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n;
    static double min;
    static int[][] arr;
    static boolean[] visit;
    static boolean[] connect;
    static List<Integer> listT;
    static List<Integer> listF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

//        st = new StringTokenizer(str, " ");
//
//        n = Integer.parseInt(st.nextToken());
//        visit = new boolean[n];
//
//        con(0, 0);

        int T = Integer.parseInt(str);
        System.out.println();

        for(int t = 0; t < T; t++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            n = Integer.parseInt(st.nextToken());

            arr = new int[n][2];
            visit = new boolean[n];

            for(int i = 0; i < n; i++){
                str = br.readLine();
                st = new StringTokenizer(str, " ");

                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;
            pws(0, 0);

            System.out.println(min);
        }
    }

    static void pws(int num, int cnt){
        if(num == n) return;
        if(cnt == n/2){
            min = Math.min(min, getMin());
//            listT = new ArrayList<>();
//            listF = new ArrayList<>();
//
//            for(int i = 0; i < n; i++){
//                if(visit[i]) listT.add(i);
//                else listF.add(i);
//            }

//            System.out.println("시작점 : " + listT);
//            System.out.println("끝점 : " + listF);

//            connect = new boolean[listF.size()];
//            System.out.println("--------------");
//            System.out.println(listT);
//            System.out.println(listF);
//            dfs(0, 0, listF.size());
//
//            System.out.println("--------------");

            return;
        }

        visit[num] = true;
        pws(num+1, cnt+1);

        visit[num] = false;
        pws(num+1, cnt);
    }

    static Double getMin(){
        int x = 0;
        int y = 0;

        for (int i = 0; i < arr.length; i++)
        {
            // 양수로 선택된 점일 경우
            if (visit[i])
            {
                x += arr[i][0];
                y += arr[i][1];
            }

            // 음수로 선택된 점일 경우
            else
            {
                x -= arr[i][0];
                y -= arr[i][1];
            }
        }

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    static void dfs(int num, double sum, int size){
        if(min < sum) return;
        if(num == size){
            min = Math.min(min, sum);

            return;
        }

        for(int i = 0; i < size; i++){
            if(!connect[i]){
                connect[i] = true;
//                double res = Math.sqrt(Math.pow((arr[listT.get(num)][0]-arr[listF.get(i)][0]), 2) + Math.pow((arr[listT.get(num)][1]-arr[listF.get(i)][1]), 2));
//                System.out.println(listT.get(num) + " : " + listF.get(i) + " => " + arr[listT.get(num)][0] + " - " + arr[listF.get(i)][0] + " / " + arr[listT.get(num)][1] + " - " + arr[listF.get(i)][1] + " -> " + res+sum);
//                dfs(num+1, sum+res, size);
                connect[i] = false;
            }
        }

    }

}