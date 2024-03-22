import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
                
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        return bfs(maps);
                
    }
    
    public int bfs(int[][] maps) {
        Deque<Node> queue = new ArrayDeque<>();
        
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Node poll = queue.pollFirst();
            
            if (poll.x == n - 1 && poll.y == m - 1)
                return poll.w;
            
            for (int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];
                
                if(inRange(x, y) && !visited[x][y] && maps[x][y] == 1) {
                    queue.add(new Node(x, y, poll.w + 1));
                    visited[x][y] = true;
                }
            }
        }
        
        return -1;

        
    }
    
    public boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    
    public class Node {
        int x, y, w;
        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
}