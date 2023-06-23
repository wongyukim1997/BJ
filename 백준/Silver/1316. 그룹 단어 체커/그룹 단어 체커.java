
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = Integer.parseInt(str);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int[] arr = new int[26];
            str = br.readLine();

            int cur = str.charAt(0);
            boolean check = true;

            for(int j = 0; j < str.length(); j++){
                int num = str.charAt(j) - 'a';

                if(cur != num){
                    arr[num]++;
                    cur = num;

                    if(arr[num] > 1){
                        check = false;
                        break;
                    }
                }
            }

            if(check) cnt++;
        }

        System.out.println(cnt);
    }

}