
import java.util.*;
import java.io.*;

public class Main {
    static int n, k, m = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n*2][2];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n*2; i++) arr[i][0] = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while(m < k){

            turn();
            move();

            // 올려
            if(arr[0][0] > 0){
                arr[0][0]--;
                arr[0][1] = 1;

                if(arr[0][0] == 0)m++;
            }

            cnt++;
        }

        System.out.println(cnt);
    }

    static void turn(){
        int temp = arr[n*2-1][0];

        for(int i = n*2-1; i >= 0; i--){
            if(i == 0){
                arr[0][0] = temp;
                arr[0][1] = 0;
            }else{
                arr[i][0] = arr[i-1][0];
                arr[i][1] = arr[i-1][1];

                // 내려
                if(i == n - 1) arr[i][1] = 0;
            }
        }
    }

    static void move(){
        for(int i = n-1; i >= 1; i--){
            if(arr[i][0] > 0 && arr[i][1] == 0 && arr[i-1][1] == 1){
                arr[i-1][1] = 0;
                arr[i][1] = 1;
                arr[i][0]--;

                if(arr[i][0] == 0) m++;
                if(m == k) return;

                if(i == n - 1) arr[i][1] = 0;
            }
        }
    }


}