import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        List<String> result = new ArrayList<>();

        List<String> test = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String word = scanner.nextLine();
            test.add(word);

            char[] list = new char[50];
            int index = 0;
            for(int j = 0; j < word.length(); j++) {
                if(word.charAt(j) == '(') {
                    list[index] = '(';
                    index++;
                }
                else if(word.charAt(j) == ')') {
                    index--;

                    if(index < 0)
                        break;

                }
            }

            if(index == 0){
                //System.out.println("YES");
                result.add("YES");
            }
            else {
                result.add("NO");
            }
        }

        for(String item : result) {
            System.out.println(item);
        }


    }
}