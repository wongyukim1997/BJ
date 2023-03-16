import java.io.*;
import java.util.*;

public class Main {
    static int Q, k, b;
    static long totalCost = 0L;
    static String name;
    static Map<String, PriorityQueue<Integer>> info = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {    // 1일 경우
                name = st.nextToken();
                k = Integer.parseInt(st.nextToken());

                if (!info.containsKey(name)) {        // name이 map에 존재하지 않을 경우 pq를 생성해준다.
                    info.put(name, new PriorityQueue<>(Collections.reverseOrder()));
                }

                PriorityQueue<Integer> pq = info.get(name);
                for (int j = 0; j < k; j++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }

            } else {                                        // 2일 경우
                name = st.nextToken();
                if (!info.containsKey(name))                // 없는 정보일 경우 건너뛴다.
                    continue;

                b = Integer.parseInt(st.nextToken());

                PriorityQueue<Integer> pq = info.get(name);

                for (int j = 0; j < b && !pq.isEmpty(); j++) {
                    totalCost += pq.poll();
                }
            }
        }
        System.out.println(totalCost);
    }
}