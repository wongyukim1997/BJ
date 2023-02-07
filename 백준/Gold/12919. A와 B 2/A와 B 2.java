import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        String T = br.readLine();

        System.out.println(BFS(S, T));
    }

    static int BFS(String S, String T){
        Queue<String> q = new LinkedList<>();

        q.add(T);

        int line = S.length();

        while (!q.isEmpty()){
            String temp = q.poll();

            if(temp.length() < line) return 0;
            if(temp.equals(S)) return 1;

            if(temp.charAt(temp.length()-1) == 'A') {
                String t = temp.substring(0,temp.length()-1);
//                System.out.println(temp + " 에서 A 빼기 : " + t);
                q.add(t);
            }

            if(temp.charAt(0) == 'B') {
                String t = reverse(temp.substring(1));
//                System.out.println(temp + " 에서 B 빼기 : " + t);
                q.add(t);
            }

        }

        return 0;
    }

    static String reverse(String temp){
        return new StringBuilder(temp).reverse().toString();
    }
}