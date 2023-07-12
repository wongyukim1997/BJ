
import java.util.*;
import java.io.*;

public class Main {
    static int n, m, l;
    static int[][] animal;
    static int[] gun;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        gun = new int[m];
        animal = new int[n][2];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i = 0; i < m; i++) gun[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            animal[i][0] = Integer.parseInt(st.nextToken());
            animal[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(gun);
        int cnt = 0;

        for(int i = 0; i < n; i++){
            int a = animal[i][0];
            int b = animal[i][1];

            int start = 0;
            int end = m;
            int mid = 0;

//            System.out.println(i);

            while(start <= end){
                mid = (start + end) / 2;
                int len = Math.abs(gun[mid] - a) + b;

                if(len <= l){
                    cnt++;
                    break;
                }
                else{
                    if(gun[mid] > a) end = mid - 1;
                    else if(gun[mid] < a) start = mid + 1;
                    else break;
                }
            }
        }

        System.out.println(cnt);
    }
}