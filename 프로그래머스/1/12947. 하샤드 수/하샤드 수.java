class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int n = x;
        int sum = 0;
        
        while(n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        
        
        if(x % sum == 0) answer = true;
        return answer;
    }
}