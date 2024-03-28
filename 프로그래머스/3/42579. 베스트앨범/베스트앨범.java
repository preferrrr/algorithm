import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, PriorityQueue<Node>> map2 = new HashMap<>();
        
        for(int i = 0 ; i < genres.length; i++) {
            if(!map1.containsKey(genres[i])) {
                map1.put(genres[i], plays[i]);
                map2.put(genres[i], new PriorityQueue());
            } else {
                map1.put(genres[i], map1.get(genres[i]) + plays[i]);
            }
            map2.get(genres[i]).add(new Node(i, plays[i]));
        }
        
        List<Genre> genresList = new ArrayList<>();
        
        for(String key : map1.keySet()) {
            genresList.add(new Genre(key, map1.get(key)));
        }
        
        Collections.sort(genresList);
        
        List<Integer> result  = new ArrayList();
        
        for(int i = 0 ; i < genresList.size(); i++) {
            Genre genre = genresList.get(i);
            PriorityQueue<Node> queue = map2.get(genre.name);
            
            int temp = 0;
            while (!queue.isEmpty() && temp < 2) {
                result.add(queue.poll().i);
                temp++;
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0 ; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    static class Node implements Comparable<Node> {
        int i, count;
        
        public Node(int i, int count) {
            this.i = i;
            this.count = count;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.count == o.count)
                return this.i - o.i;
                
            return o.count - this.count;
        }
    }
    
    static class Genre implements Comparable<Genre> {
        String name;
        int max;
        
        public Genre(String name, int max) {
            this.name = name;
            this.max = max;
        }
        
        @Override
        public int compareTo(Genre o) {

            return o.max - this.max;
        }
    }
}