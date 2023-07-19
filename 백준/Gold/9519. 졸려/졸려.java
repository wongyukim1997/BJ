
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int x = Integer.parseInt(str);
        str = br.readLine();

        String temp = str;
        int cycle = 0;

        for(int i = 1; i <= x; i++) {
            str = close(str);
            if(str.equals(temp)) {
                cycle = i;
                break;
            }
        }

        if(cycle != 0) {
            int c = x % cycle;
//            System.out.println(cycle + " " + c );
            for (int i = 0; i < c; i++) {
                temp = close(temp);
            }
            System.out.println(temp);
        }
        else System.out.println(str);


    }

    static String close(String str){
        String front = "";
        String back = "";
        for(int i = 0; i < str.length(); i++){
            if(i % 2 == 0) front = front + str.charAt(i);
            else back = str.charAt(i) + back;
        }

        return front + back;
    }
}