import java.util.*;

class Solution {

    static List<int[][]> puzzles = new ArrayList<>();
    static List<int[][]> empties = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {
        
        int answer = -1;

        int n = table.length;
        boolean[][] boardVisited, tableVisited;
        boardVisited = new boolean[n][n];
        tableVisited = new boolean[n][n];

        getPuzzles(table, 1, tableVisited);
        getPuzzles(game_board, 0, boardVisited);

        answer = solve();

        return answer;
    }

    public int solve() {

        boolean[] visit = new boolean[puzzles.size()];
        int answer = 0;
        for (int i = 0; i < empties.size(); i++) {
            for (int j = 0; j < puzzles.size(); j++) {

                if (!visit[j]) {
                    int count = isMatch(i, j);

                    if (count != 0) {
                        visit[j] = true;
                        answer += count;
                        break;
                    }
                }

            }
        }
        return answer;
    }

    public int isMatch(int x, int y) {
        int[][] a = empties.get(x);
        int[][] b = puzzles.get(y);


        for (int d = 0; d < 4; d++) {
            if (a.length == b.length && a[0].length == b[0].length) {

                boolean flag = true;
                int match = 0;

                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[0].length; j++) {
                        if (a[i][j] != b[i][j]) {
                            flag = false;
                            break;
                        } else if (a[i][j] == b[i][j] && a[i][j] == 1)
                            match++;

                    }
                }

                if (flag)
                    return match;


            }
            if (d < 3)
                b = rotate(b);
        }

        return 0;
    }


    //퍼즐 조각 배열로 바꿔서 저장.
    public void getPuzzles(int[][] arr, int flag, boolean[][] visited) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (arr[i][j] == flag && !visited[i][j]) {
                    int[][] temp = puzzleToArray(arr, i, j, flag, visited);
                    if (flag == 1) puzzles.add(temp);
                    else empties.add(temp);
                }
            }
        }
    }

    public int[][] puzzleToArray(int[][] arr, int i, int j, int flag, boolean[][] visited) {

        Deque<Node> queue = new ArrayDeque<>();
        ArrayList<Node> list = new ArrayList<>();

        Node start = new Node(i, j);

        queue.add(start);
        visited[i][j] = true;

        list.add(start);

        int maxX = -1, maxY = -1, minX = 51, minY = 51;

        while (!queue.isEmpty()) {

            Node poll = queue.pollFirst();

            if (maxX < poll.x)
                maxX = poll.x;
            if (minX > poll.x)
                minX = poll.x;
            if (maxY < poll.y)
                maxY = poll.y;
            if (minY > poll.y)
                minY = poll.y;

            for (int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];

                if (x >= 0 && y >= 0 && x < arr.length && y < arr.length && arr[x][y] == flag && !visited[x][y]) {
                    Node node = new Node(x, y);

                    queue.add(node);
                    visited[x][y] = true;

                    list.add(node);
                }
            }

        }

        int[][] puzzle = new int[maxX - minX + 1][maxY - minY + 1];

        for (int k = 0; k < list.size(); k++) {
            Node temp = list.get(k);
            puzzle[temp.x - minX][temp.y - minY] = 1;
        }

        return puzzle;

    }


    //회전
    public int[][] rotate(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] rotated = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - i - 1] = arr[i][j];
            }
        }

        return rotated;
    }

    public class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}