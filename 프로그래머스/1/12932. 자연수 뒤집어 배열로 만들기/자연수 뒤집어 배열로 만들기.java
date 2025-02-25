class Solution {
    public int[] solution(long n) {
        long num = n;
        int len = 0;
        
        while(num > 0) {
            num = num / 10;
            len++;
        }
        
        int[] answer = new int[len];
        len = 0;
        
        while(n > 0) {
            answer[len++] = (int)(n % 10);
            n = n / 10;
        }
        
        return answer;
    }
}