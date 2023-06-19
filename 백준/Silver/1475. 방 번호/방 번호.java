
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = str.length();
        int[] arr = new int[10];

        for(int i = 0; i < n; i++){
            int num = Character.getNumericValue(str.charAt(i));
            arr[num]++;
        }

        int check = (arr[6] + arr[9]) % 2;
        int temp = (arr[6] + arr[9]) / 2;
        if(check == 0){
            arr[6] = temp;
            arr[9] = temp;
        }else{
            arr[6] = temp + 1;
            arr[9] = temp + 1;
        }

        int max = 0;
        for(int i = 0; i < 10; i++){
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }
}