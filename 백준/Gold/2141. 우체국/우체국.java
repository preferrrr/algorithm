import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long sumPeople = 0;
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node node = new Node();
            node.location = Long.parseLong(st.nextToken());
            node.people = Long.parseLong(st.nextToken());
            list.add(node);
            sumPeople += node.people;
        }

        Collections.sort(list);

        long temp = 0;
        long result = 0;
        for (int i = 0; i < n; i++) {
            temp += list.get(i).people;
            if ((sumPeople + 1) / 2 <= temp) {
                result = list.get(i).location;
                break;
            }

        }

        System.out.println(result);


    }

    public static class Node implements Comparable<Node> {
        long location;
        long people;

        @Override
        public int compareTo(Node o) {
            if (this.location == o.location)
                return (int) (this.people - o.people);
            return (int) (this.location - o.location);
        }
    }


}