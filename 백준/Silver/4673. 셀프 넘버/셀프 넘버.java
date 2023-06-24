
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        boolean[] arr = new boolean[10001];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < 10001; i++){
            int a = i;

            int sum = a;
            while(a > 0){
                sum += a%10;
                a /= 10;
            }

            if(sum <= 10000) arr[sum] = true;
        }

        for(int i = 1; i < 10001; i++){
            if(!arr[i]) sb.append(i + "\n");
        }

        System.out.println(sb);
    }
}