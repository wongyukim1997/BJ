
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] arr = new int[str1.length()+1][str2.length()+1];

        int max = 0;
        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    arr[i+1][j+1] = arr[i][j] + 1;
                    max = Math.max(arr[i+1][j+1], max);
                }
            }
        }

        System.out.println(max);
    }
}