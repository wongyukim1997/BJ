
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        long max = 0;

        for(int i = 0; i < n; i++){
            str = br.readLine();
            arr[i] = Integer.parseInt(str);

            max = Math.max(max, arr[i]);
        }

        long start = 1, end = max*m;

        while(start <= end){
            long mid = (start + end) / 2;
            if(check(mid)){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        System.out.println(start);
    }

    // mid 시간 내로 사람들이 심사를 받을 수 있는가
    static boolean check(long mid){
        long count = 0;
        for(int i = 0; i < n; i++){
            count += mid / arr[i];
        }

        // 만약 심사 받는 인원이 m 보다 작다면 실패
        if(count >= m){
            return true;
        }else{
            return false;
        }
    }
}