
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += count(str, arr[i]);
            str = str.replaceAll(arr[i], "!");
//            System.out.println(str);
        }

        str = str.replaceAll("!", "");
//        System.out.println(str);
        sum += str.length();

        System.out.println(sum);
    }

    static int count(String str, String ch){
        return (str.length() - str.replaceAll(ch, "").length()) / ch.length();
    }
}