import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n;
    static List<Integer>[] arr;
    static boolean[] team;
    static boolean[] visit;
    static List<Integer> resB = new ArrayList<>();
    static List<Integer> resW = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);
        visit = new boolean[n+1];
        arr = new List[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());

            for(int j = 0; j < a; j++){
                int b = Integer.parseInt(st.nextToken());
                arr[i].add(b);
            }
        }
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i = 1; i <= n; i++){
            if(!visit[i]) {
                visit[i] = true;
                resW.add(i);
                dfs(i, true);
            }
        }

        System.out.println(resB.size());
        Collections.sort(resB);
        for(int i : resB) System.out.print(i + " ");

        System.out.println();

        System.out.println(resW.size());
        Collections.sort(resW);
        for(int i : resW) System.out.print(i + " ");
    }

    static void dfs(int num, boolean isWhite){
        //백팀인데
        if(isWhite) {
            for (int i : arr[num]) {
                //싫어하는 사람이면 청팀
                if (!visit[i]) {
                    visit[i] = true;
                    resB.add(i);
                    dfs(i, false);
                }
            }
        }else{//청팀인데
            for (int i : arr[num]) {
                //싫어하는 사람이면 백팀
                if (!visit[i]) {
                    visit[i] = true;
                    resW.add(i);
                    dfs(i, true);
                }
            }
        }
    }



}