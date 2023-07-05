
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int T = Integer.parseInt(str);

        for(int t = 0; t < T; t++){
            str = br.readLine();
            int[] arr = new int[26];

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                arr[c-'a']++;
            }

            String w = br.readLine();
            int k = Integer.parseInt(w);

            int min = Integer.MAX_VALUE;
            int max = 0;

            for(int c = 0; c < 26; c++){
                // 알파벳의 개수가 k 이상일 때 찾으면 됨
                if(arr[c] >= k){
                    char a = (char)('a' + c);

                    int right = 0;
                    int left = 0;
                    int cnt = 0;

                    for(int i = 0; i < str.length(); i++){
                        if(str.charAt(i) == a) {
                            cnt++;

                            if (cnt < k) {
                                if(cnt == 1) left = i;
                            }
                            else if (cnt == k){
                                if(cnt == 1) left = i;

                                right = i;
                                int temp = right - left + 1;
//                                System.out.println(a + " 단어가 이 길이임 : " + temp);
                                min = Math.min(min, temp);
                                max = Math.max(max, temp);
                            }
                            else {
                                right = i;

                                for(int j = left+1; j <= i; j++){
                                    if(str.charAt(j) == a){
                                        left = j;
                                        break;
                                    }
                                }

                                int temp = right - left + 1;
//                                System.out.println(a + " 단어가 이 길이임, right : " + right + ", left : " + left + ", 길이 : " + temp);
                                min = Math.min(min, temp);
                                max = Math.max(max, temp);
                            }
                        }
                    }
                }
            }

            if(max == 0 || min == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(min + " " + max);
        }

    }
}