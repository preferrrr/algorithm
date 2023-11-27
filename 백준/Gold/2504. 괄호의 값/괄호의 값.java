import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        //(): 2, []: 3, (X): 2*, [X]: 3*, XY: X + Y

        // ( : -2, [ : -3
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            char w = line.charAt(i);

            if (w == '(') {
                stack.push(-2);
            } else if (w == '[') {
                stack.push(-3);
            } else if (w == ')') {
                if (stack.isEmpty()) {
                    result = 0;
                    stack.clear();
                    break;
                } else if (stack.peek() == -2) {
                    stack.pop();
                    stack.push(2);
                } else {

                    int sum = 0;
                    while(!stack.isEmpty() && stack.peek() > 0) {
                        sum += stack.pop();
                    }

                    if(stack.isEmpty() || stack.peek() != -2) {
                        result = 0;
                        stack.clear();
                        break;
                    } else if(stack.peek() == -2) {
                        stack.pop();
                        stack.push(sum * 2);
                    }

                }
            } else if (w == ']') {

                if(stack.isEmpty()) {
                    result = 0;
                    stack.clear();
                    break;
                } else if(stack.peek() == -3) {
                    stack.pop();
                    stack.push(3);
                } else {

                    int sum = 0;
                    while (!stack.isEmpty() && stack.peek() > 0) {
                        sum += stack.pop();
                    }

                    if(stack.isEmpty() || stack.peek() != -3) {
                        result = 0;
                        stack.clear();
                        break;
                    } else if(stack.peek() == -3) {
                        stack.pop();
                        stack.push(sum * 3);
                    }
                }

            }


        }


        while (!stack.isEmpty()) {
            if(stack.peek() < 0) {
                result = 0;
                break;
            }
            result += stack.pop();
        }

        System.out.println(result);
    }

}