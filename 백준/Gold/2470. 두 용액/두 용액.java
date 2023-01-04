
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int end = n-1;
        long sum = Integer.MAX_VALUE;

        long a = 0, b = 0;

        for(int i = 0; i < n; i++) {
            if(i == end) break;

            long s = arr[i] + arr[end];
            long temp = Math.abs(s);
            if(temp <= sum){
                sum = temp;
                a = arr[i];
                b = arr[end];
            }

            if(temp == 0) break;

            if(s > 0){
                i--;
                end--;
            }
        }

        System.out.println(a + " " + b);
    }
}

//-5 -4 -3 1 5 7