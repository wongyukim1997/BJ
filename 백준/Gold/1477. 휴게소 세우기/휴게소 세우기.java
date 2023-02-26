
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n, m, l;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        if(n != 0){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
        }

        list.add(0);
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());

            list.add(a);
        }

        list.add(l);
        Collections.sort(list);
//        System.out.println(list);

        int left = 1;
        int right = l-1;

        while(left <= right){
            if(right == 0) break;
//            System.out.println(left);

            int mid = (left + right) / 2;
            int cnt = 0;

            //mid는 휴게소를 설치하는 거리 값이고
            //list는 원래 설치된 휴게소 위치가 저장되어 있음
            //list.get(i)-list.get(i-1) -> 순서대로 정렬되어 있으므로, 자신의 왼쪽 휴게소 사이의 거리를 의미
            //휴게소 사이의 거리를 mid 값으로 나누어서, 휴게소를 몇개 mid 거리 안에 넣을 수 있는지 cnt 에 더해준다
            for(int i = 1; i < n+2; i++){
                cnt += (list.get(i) - list.get(i-1) - 1)/mid;
            }

            if(cnt > m) {
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(left);
    }

}