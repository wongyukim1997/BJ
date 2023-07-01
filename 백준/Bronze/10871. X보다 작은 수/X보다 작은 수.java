
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a < m) System.out.print(a + " ");
        }
    }
}