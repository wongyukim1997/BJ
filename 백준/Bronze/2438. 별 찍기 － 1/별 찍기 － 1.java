
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(str);

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}