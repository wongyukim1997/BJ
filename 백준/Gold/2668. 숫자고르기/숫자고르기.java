
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean isCycle;
    static boolean[] check;
    static List<Integer> result = new ArrayList<>();
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        n = Integer.parseInt(str);

        list = new List[n+1];


        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            int a = Integer.parseInt(br.readLine());
            list[i].add(a);
        }

        for(int i = 1; i <= n; i++){
            check = new boolean[n+1];
            check[i] = true;
            isCycle = false;

            dfs(i, i);
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(int i : result) System.out.println(i);
    }

    static void dfs(int start, int num){

        for(int i : list[num]){
            if(i == start){
                isCycle = true;
                if(!result.contains(i)) result.add(i);
                return;
            }
            if(!check[i]){
                check[i] = true;
                dfs(start, i);

                if(isCycle && !result.contains(i)) result.add(i);
            }
        }
    }
}