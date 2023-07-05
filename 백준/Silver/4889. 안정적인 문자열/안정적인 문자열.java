import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        //}}{}{{
        //열린게 없는데 닫힌게 나왔다? => 바꿔줌
        //열려있는 개수가 남은 개수와 같아지면 => 남은거 전부 닫혀야됨
        //{{{{ {{{{
        //open = 4, open=3,
        //{ {} {{ {}{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = 1;
        while (true) {
            String stable = br.readLine();
            if (stable.contains("-"))
                break;

            int open = 0;
            int change = 0;
            for (int i = 0; i < stable.length(); i++) {
                if (open == 0 && stable.charAt(i) == '}') {
                    change++;
                    open++;
                }
                else if (open == stable.length() - i && stable.charAt(i) == '{') {
                    change++;
                    open--;
                }
                else if (stable.charAt(i) == '{')
                    open++;
                else if (stable.charAt(i) == '}')
                    open--;
            }

            sb.append(num + ". " + change + "\n");
            num++;
        }

        System.out.println(sb);

    }
}