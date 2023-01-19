import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, c;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            arr[i] = Integer.parseInt(str);
        }

        Arrays.sort(arr);
        int start = 1;
        int end = arr[n-1];

        while(start < end){
            int mid = (start+end) / 2;

            int s = 0;
            int cnt = 1;
            for(int i = 1; i < n; i++){
                if(arr[i] - arr[s] >= mid){
                    cnt++;
                    s = i;
                }
            }

            if(cnt < c){
                end = mid;
            }else{
//                System.out.println(start + " " + mid + " " + end);
                start = mid+1;
            }
        }

        System.out.println(start-1);
    }
}