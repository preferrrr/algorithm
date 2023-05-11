import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        //abcde,
        String word = scanner.next();
        for (int i = 1; i <= word.length() - 2; i++) {
            for (int j = i + 1; j <= word.length() - 1; j++) {

                String token = "";
                StringBuilder builder = new StringBuilder();

                builder.append(word.substring(0, i));
                token += builder.reverse().toString();
                builder.delete(0,builder.length());

                builder.append(word.substring(i, j));
                token += builder.reverse().toString();
                builder.delete(0,builder.length());

                builder.append(word.substring(j,word.length()));
                token += builder.reverse().toString();
                builder.delete(0,builder.length());
                list.add(token);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));

    }

}