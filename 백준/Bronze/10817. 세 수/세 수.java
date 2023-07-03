
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        List<Integer> list = new ArrayList<>();

        list.add(Integer.parseInt(st.nextToken()));
        list.add(Integer.parseInt(st.nextToken()));
        list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);
        System.out.println(list.get(1));
    }
}