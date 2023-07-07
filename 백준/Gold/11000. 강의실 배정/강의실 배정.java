import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            Room room = new Room();
            StringTokenizer st = new StringTokenizer(br.readLine());
            room.x = Integer.parseInt(st.nextToken());
            room.y = Integer.parseInt(st.nextToken());

            rooms[i] = room;
        }
        Arrays.sort(rooms);

        PriorityQueue<Integer> queue = new PriorityQueue();

        queue.add(rooms[0].y);

        for(int i = 1; i < n; i++) {
            if(queue.peek() <= rooms[i].x) {
                queue.poll();
            }
            queue.offer(rooms[i].y);

        }

        System.out.println(queue.size());

    }

    public static class Room implements Comparable<Room> {
        int x;
        int y;

        @Override
        public int compareTo(Room o) {
            if (this.x == o.x) {
                return this.y - this.y;
            }
            return this.x - o.x;
        }
    }



}