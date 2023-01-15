import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        int n = Integer.parseInt(str);
        int[][] arr = new int[n][n];
        long max = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max += arr[i][j];
                end = Math.max(end, arr[i][j]);
            }
        }
        //System.out.println(max);

        long sum = 0;
        int start = 0;
        int mid = 0;

        while (start+1 < end) {
            //mid = (int)Math.ceil((start + end)/2.0);
            mid = (start+end)/2;
            sum = 0;

            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++){
                    if(arr[i][j] > mid){
                        sum += mid;
                    }else{
                        sum += arr[i][j];
                    }
                }
            }
            //System.out.println(sum + " " + mid);
            if (((double)sum / max) >= 0.5) {
                end = mid;
            } else {
                start = mid;
            }
        }

        System.out.println(end);
    }

}