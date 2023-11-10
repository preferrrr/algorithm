import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        boolean flag = false;
        for(int i = 0 ; i < word.length(); i++) {
            //3 3
            char temp = word.charAt(i);
            if(temp == '(') {
                stack.push(temp);
                flag = true;
            }
            else {
                stack.pop();
                if(flag) {
                    result += stack.size();
                    flag = false;
                }
                else
                    result++;
            }
        }

        System.out.println(result);
    }
}