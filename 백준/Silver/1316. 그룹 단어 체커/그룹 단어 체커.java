import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        int count = 0;

        for (int i = 0; i < N; i++) {

            char[] list = new char[100];
            String word = scanner.nextLine();

            int idx = 0;

            boolean group = true;

            for(int j = 0 ; j < word.length(); j++) {

                if(idx == 0 || word.charAt(j) != word.charAt(j-1)) {

                    boolean dup = false;

                    for(int k = 0; k < idx; k++) {

                        if(word.charAt(j) == list[k]) {
                            dup = true;
                        }
                    }

                    if(dup == false) {
                        list[idx] = word.charAt(j);
                        idx++;
                    }
                    else {
                        group = false;
                    }
                }
            }

            if(group == true) {
                count++;
            }
        }
        System.out.println(count);
    }
}