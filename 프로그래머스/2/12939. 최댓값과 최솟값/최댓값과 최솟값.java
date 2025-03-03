import java.util.*;
import java.io.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ");
        int n = st.countTokens();
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
            
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(min > num) min = num;
            if(max < num) max = num;
        }
        
        answer = min + " " + max;
        return answer;
    }
}