class Solution {
    public long solution(long n) {
        long answer = -1;
        
        int num = (int)(Math.sqrt(n) * 100 % 10);
        
        if(num == 0) {
            answer = (long)(Math.pow(Math.sqrt(n)+1, 2));
        }
        
        return answer;
    }
}