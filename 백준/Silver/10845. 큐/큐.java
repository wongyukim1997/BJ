import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        int n = Integer.parseInt(str);
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
//            System.out.println(str);

            if(st.countTokens() > 1){
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
            }
            else {
                String comm = st.nextToken();

                if (comm.equals("pop")) {
                    if (!dq.isEmpty()) System.out.println(dq.pop());
                    else System.out.println("-1");
                } else if (comm.equals("front")) {
                    if (!dq.isEmpty()) System.out.println(dq.getFirst());
                    else System.out.println("-1");
                } else if (comm.equals("back")) {
                    if (!dq.isEmpty()) System.out.println(dq.getLast());
                    else System.out.println("-1");
                } else if (comm.equals("size")) {
                    System.out.println(dq.size());
                } else if (comm.equals("empty")) {
                    if (!dq.isEmpty()) System.out.println("0");
                    else System.out.println("1");
                }
            }

//            System.out.println(dq);
//            System.out.println();
        }
    }
}