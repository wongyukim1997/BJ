
import java.io.*;
import java.util.*;

public class Main {
    static int n, l;
    static int sum = 0, init = 0;
    static int min = Integer.MAX_VALUE, max = 0;
    static int[] arr = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);
        l = countNumber(n);

        sum = countOdd(n, l);
        init = sum;

        if(l > 2){
            combination(0, 0, n, l-1, new int[2]);

            System.out.println(min + " " + max);
        }
        else if(l == 2){
            int a = n % 10;
            int b = n / 10;
            int ab = a + b;

            if(countNumber(ab) == 2){
                sum += countOdd(ab, 2);

                int aba = ab % 10;
                int abb = ab / 10;
                if((aba+abb) % 2 == 1) sum++;
            }
            else{
                if(ab % 2 == 1) sum++;
            }

            System.out.println(sum + " " + sum);
        }
        else System.out.println(sum + " " + sum);
    }

    // 어느 부분을 자를지 선택?
    static void combination(int cnt, int num, int target, int len, int[] src){
        if(cnt == 2){
//            System.out.println(Arrays.toString(src));
            divide(target, src);
            return;
        }

        for(int i = num; i < len; i++){
            src[cnt] = arr[i];
            combination(cnt+1, i+1, target, len, src);
        }
    }

    static void divide(int num, int[] src){
        int a = num / src[1];
        num %= src[1];
        int b = num / src[0];
        int c = num % src[0];

        int res = a + b + c;
        int len = countNumber(res);
        int cnt = countOdd(res, len);
        sum += cnt;
//        System.out.println(res + " " + len);
        if(len > 2){

            combination(0, 0, res, len-1, new int[2]);
        }
        else if(len == 2){
            int resA = res / 10;
            int resB = res % 10;
            int resAB = resA + resB;

            if(countNumber(resAB) == 2){
                sum += countOdd(resAB, 2);

                int aba = resAB % 10;
                int abb = resAB / 10;
                if((aba+abb) % 2 == 1) sum++;
            }
            else{
                if(resAB % 2 == 1) sum++;
            }

            max = Math.max(max, sum);
            min = Math.min(min, sum);
            sum = init;
        }
        else {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            sum = init;
        }
    }

    static int countNumber(int num){
        int cnt = 0;

        // 자리 수 구하기
        while(num > 0){
            cnt++;
            num /= 10;
        }
        return cnt;
    }

    static int countOdd(int num, int len){
        int cnt = 0;

        // 각 자리가 홀수면 +1
        while(num > 0){
            int temp = (int)Math.pow(10, --len);
            int res = num / temp;
            num %= temp;

            if(res % 2 != 0) cnt++;
        }
        return cnt;
    }

}