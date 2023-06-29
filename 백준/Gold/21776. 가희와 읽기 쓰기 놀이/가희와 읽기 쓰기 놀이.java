import java.util.*;
import java.io.*;

public class Main {

    static int n, c;
    static List<Integer>[] user;
    static List<String>[] card;
    static boolean[] select;
    static int[] arr;
    static List<Integer> srcList = new ArrayList<>();
    static Set<String> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        user = new List[n];
        card = new List[c];
        select = new boolean[c];
        arr = new int[c];

        for(int i = 0; i < n; i++) user[i] = new ArrayList<>();
        for(int i = 0; i < c; i++) card[i] = new ArrayList<>();

        // 유저 입력
        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int m = Integer.parseInt(st.nextToken());

            for(int j = 0; j < m; j++){
                user[i].add(Integer.parseInt(st.nextToken())-1);
            }
        }

        // 카드 입력
        for(int i = 0; i < c; i++){
            str = br.readLine();
            st = new StringTokenizer(str, ",");
            int m = st.countTokens();

            for(int j = 0; j < m; j++){
                card[i].add(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < user[i].size(); j++) arr[cnt++] = i;
        }

        playPermutation(0);
//        List<String> resultList = new ArrayList(result);
//        Collections.sort(resultList);
        for(String res : result) System.out.println(res);
    }

    // user 순서 순열로 구하기
    static void playPermutation(int num){
        if(num == c){
            readCard();
            return;
        }

        for(int i = 0; i < n; i++){
            if (user[i].size() != 0) {
                int temp = user[i].get(0);
                srcList.add(temp);
                user[i].remove(0);
                playPermutation(num + 1);
                srcList.remove(Integer.valueOf(temp));
                user[i].add(0, temp);
            }
        }

//        for(int i = 0; i < c; i++){
//            if(select[i]) continue;
//            select[i] = true;
//            src[num] = arr[i];
//            playPermutation(num+1, src);
//            select[i] = false;
//        }
    }

    // 정해진 순서대로 유저의 카드 읽기
    static void readCard(){
        String res = "";

        // 순서대로 카드 뽑기
        for(int cardNum : srcList) {
            // 카드 안에 있는 연산 구하기
//            int cardNum = user[userNum].get(0);
//            user[userNum].remove(0);
//            user[userNum].add(cardNum);

            for (String nowCard : card[cardNum]) {
                StringTokenizer cardSt = new StringTokenizer(nowCard, " ");
                String cal = cardSt.nextToken();
                String s = cardSt.nextToken();

                if(cal.equals("ADD")) res = res + s;
                else {
                    int num = Integer.parseInt(s);

                    if(res.length() > num) res = res.substring(0, num) + res.substring(num + 1);
                    else res = "ERROR";
                }
//                res = calculate(cardSt.nextToken(), cardSt.nextToken(), res);

                // ERROR 나오면 그대로 리턴
                if (res.equals("ERROR")) {
                    result.add(res);
                    return;
                }
            }
        }
        
        if(res.length() == 0) res = "EMPTY";
//        System.out.println(res);
        result.add(res);
    }

    // 연산 cal 과 문자열 s 를 넘겨받아 문자열 res 계산
    static String calculate(String cal, String s, String res){
        if(cal.equals("ADD")) res = res + s;
        else {
            int num = Integer.parseInt(s);

            if(res.length() > num) res = res.substring(0, num) + res.substring(num + 1);
            else res = "ERROR";
        }

        return res;
    }
}