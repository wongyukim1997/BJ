import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(str);

        for(int t = 0; t < T; t++) {
            str = br.readLine();
            int n = str.length();

            int left = 0;
            int right = n - 1;
            int checkLeft = 0;
            int checkRight = 0;
            int cnt = 0;

            while(left <= right){
                char a = str.charAt(left);
                char b = str.charAt(right);

                if(a != b){
                    if(cnt == 1){
                        cnt = 2;
                        if(checkRight != -1 && checkRight != 0) {
                            right = checkRight;
                            left = checkLeft;

                            checkRight = -1;
                        }
                        else break;
                    }

                    cnt = 1;
                    if((str.charAt(left) == str.charAt(right-1)) && checkRight == 0) {
                        checkLeft = left;
                        checkRight = right;
                        left--;
                    }
                    else if(str.charAt(right) == str.charAt(left+1)) {
                        right++;
                    }
                    else{
                        cnt++;
                        break;
                    }
                }

                left++;
                right--;
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}