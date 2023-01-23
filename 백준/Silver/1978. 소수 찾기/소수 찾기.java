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

        n = Integer.parseInt(str);
        arr = new int[n];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == 1) continue;
            else if(arr[i] == 2){
                cnt++;
                continue;
            }
            boolean check = true;
            for(int j = 2; j < arr[i]; j++){
                if(arr[i] % j == 0){
                    check = false;
                    break;
                }
            }

            if(check) cnt++;
        }

        System.out.println(cnt);
    }
}