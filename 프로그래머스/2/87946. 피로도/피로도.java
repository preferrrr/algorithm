class Solution {
    
    static int max = 0;
    static boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        
        visit = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return max;
        
    }
    
    
    public void dfs(int cur, int d, int[][] arr) {
        if (d > max)
            max = d;
        
        for (int i = 0 ; i < arr.length; i++) {
            if (!visit[i] && cur >= arr[i][0]) {
                visit[i] = true;
                dfs(cur - arr[i][1], d + 1, arr);
                visit[i] = false;
            }            
        }
    }
}