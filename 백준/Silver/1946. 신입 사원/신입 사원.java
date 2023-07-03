import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Grade implements Comparable<Grade> {
        int x;
        int y;
        public Grade(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Grade o) {
            return this.x-o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t; i++) {

            int n = Integer.parseInt(br.readLine());
            Grade[] grades = new Grade[n];

            for(int j = 0 ; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Grade grade = new Grade(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                grades[j] = grade;
            }

            Arrays.sort(grades);

            max(grades);
        }

        System.out.print(sb);
    }

    public static StringBuilder sb = new StringBuilder();

    public static void max(Grade[] grades) {
        int count = 1;
        int criteria = grades[0].y;
        for(int i = 1 ; i < grades.length; i++) {
            if(criteria > grades[i].y) {
                count++;
                criteria = grades[i].y;
            }
        }

        sb.append(count+"\n");
    }
}