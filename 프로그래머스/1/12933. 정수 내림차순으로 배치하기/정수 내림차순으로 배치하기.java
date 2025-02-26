import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        long p = 1;
        
        List<Integer> list = new ArrayList<>();
        
        while(n > 0) {
            list.add((int)(n % 10));
            n = n / 10;
        }
        
        Collections.sort(list);
        
        for(int i : list) {
            answer += i * p;
            p *= 10;
        }
        
        
        return answer;
    }
}