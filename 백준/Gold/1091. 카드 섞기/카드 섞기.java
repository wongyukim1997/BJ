
import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] P, S, arr, now, copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);

        arr = new int[n];
        now = new int[n];
        copy = new int[n];
        P = new int[n];
        S = new int[n];

        k =  n/3;

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++) P[i] = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++) S[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) arr[i] = i;

        int cnt = 0;
        boolean cycle = false;
        copyCard(arr, now);

        while(!check()){

            copyCard(now, copy);
            turn();

            if(isCycle()) {
                cycle = true;
                break;
            }
            cnt++;
        }

        if(cycle) System.out.println(-1);
        else System.out.println(cnt);
    }

    static void turn(){
        for(int i = 0; i < n; i++) now[S[i]] = copy[i];
    }

    static void copyCard(int[] a, int[] b) {
        for(int i = 0; i < n; i++) b[i] = a[i];
    }

    static boolean isCycle(){
        for(int i = 0; i < n; i++){
            if(arr[i] != now[i]) return false;
        }

        return true;
    }

    static boolean check(){
        for(int i = 0; i < n; i++){
            boolean c = false;
            for(int j = 0; j < k; j++){
                if(arr[i] == now[P[i] + 3*j]) c = true;
            }
            if(!c) return false;
        }

        return true;
    }
}