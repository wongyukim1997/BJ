

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = Integer.parseInt(str);


        for(int k = 1; k <= n; k++) {
            int[] arr = new int[26];
            str = br.readLine();
            str = str.toLowerCase();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c > 96 && c < 123) arr[c - 'a']++;
                else continue;
            }

            boolean isP = true;
            boolean isD = true;
            boolean isT = true;

            for (int i = 0; i < 26; i++) {
                if (arr[i] < 1) isP = false;
                else if (arr[i] < 2) isD = false;
                else if (arr[i] < 3) isT = false;
            }

            System.out.print("Case " + k + ": ");
            if (!isP) System.out.println("Not a pangram");
            else if (isP && !isD) System.out.println("Pangram!");
            else if (isD && !isT) System.out.println("Double pangram!!");
            else if (isT) System.out.println("Triple pangram!!!");
        }
    }

}