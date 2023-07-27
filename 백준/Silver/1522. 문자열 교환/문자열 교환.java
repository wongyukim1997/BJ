
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = str.length();

        int a = 0;

        for(int i = 0; i < n; i++) if(str.charAt(i) == 'a') a++;

        int right = a;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int cnt = 0;

            for(int j = i; j < right; j++){
                if(j >= n){
                    if (str.charAt(j-n) == 'b') cnt++;
                }
                else {
                    if (str.charAt(j) == 'b') cnt++;
                }
            }

//            System.out.println(cnt);
            min = Math.min(min, cnt);
            right++;
        }

        System.out.println(min);
    }
}