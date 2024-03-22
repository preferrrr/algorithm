class Solution {
    
    static int answer = 0;
    static int goal;
    public int solution(int[] numbers, int target) {
        goal = target;
        
        dfs(0, 0, numbers);
        
        return answer;
    }
    
    public void dfs(int cur, int i, int[] arr) {
        
        if (i == arr.length) {
            if(cur == goal)
                answer++;
            return;
        }
        
        
        dfs(cur - arr[i], i + 1, arr);
        
        dfs(cur + arr[i], i + 1, arr);
        
    }
}