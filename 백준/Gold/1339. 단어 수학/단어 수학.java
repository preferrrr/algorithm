import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Alpha> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            for (int j = 0; j < word.length(); j++) {
                String wordTemp = String.valueOf(word.charAt(j));
                double numTemp = Math.pow(10, word.length()- j - 1);

                int index = find(list, wordTemp);

                if(index != -1) {
                    list.get(index).value += numTemp;
                } else {
                    Alpha alpha = new Alpha();
                    alpha.key = wordTemp;
                    alpha.value = (int)numTemp;
                    list.add(alpha);
                }

            }
        }

        Collections.sort(list);

        int k = 9;
        int result = 0;

        for(Alpha alpha : list) {
            result += alpha.value * k;
            k--;
        }

        System.out.println(result);


    }

    public static class Alpha implements Comparable<Alpha> {
        String key;
        int value;

        @Override
        public int compareTo(Alpha o) {
            return o.value - this.value;
        }
    }

    public static int find(List<Alpha> list, String alpha) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).key.equals(alpha)) {
                return i;
            }
        }

        return -1;
    }
}