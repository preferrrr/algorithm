import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static boolean[] primeNumbers = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Arrays.fill(primeNumbers, true);
        findPrimeNumbers();


        for (int test = 0; test < testcase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = bfs(start, end);

            if (result == -1)
                sb.append("Impossible\n");
            else sb.append(result + "\n");

        }

        System.out.print(sb);

    }

    static int bfs(int start, int end) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dist = new int[10000];
        Arrays.fill(dist, -1);

        deque.add(start);
        dist[start] = 0;

        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();

            if (poll == end)
                break;

            int a = poll % 1000; // 373
            int b = (poll / 1000) * 1000 + (poll % 100); // 1073
            int c = (poll / 100) * 100 + (poll % 10); // 1303
            int d = (poll / 10) * 10; // 1370

            for (int i = 1000; i <= 9000; i += 1000) {
                int x = a + i;

                if (dist[x] == -1 && primeNumbers[x]) {
                    dist[x] = dist[poll] + 1;
                    deque.add(x);
                }
            }

            for (int i = 0; i <= 900; i += 100) {
                int x = b + i;

                if (dist[x] == -1 && primeNumbers[x]) {
                    dist[x] = dist[poll] + 1;
                    deque.add(x);
                }
            }

            for (int i = 0; i <= 90; i += 10) {
                int x = c + i;

                if (dist[x] == -1 && primeNumbers[x]) {
                    dist[x] = dist[poll] + 1;
                    deque.add(x);
                }
            }

            for (int i = 0; i <= 9; i += 1) {
                int x = d + i;

                if (dist[x] == -1 && primeNumbers[x]) {
                    dist[x] = dist[poll] + 1;
                    deque.add(x);
                }
            }

        }

        return dist[end];
    }

    static void findPrimeNumbers() {
        primeNumbers[1] = false;
        for (int i = 2; i <= 100; i++) {
            if (!primeNumbers[i])
                continue;

            for (int j = i * 2; j < 10000; j += i) {
                if (j % i == 0) {
                    primeNumbers[j] = false;
                }
            }
        }
    }


}