import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        String input = "";

        //int N = scanner.nextInt();
        int N = Integer.parseInt(reader.readLine());
        //scanner.nextLine();
        List<Integer> stack = new ArrayList<>();

        for(int i = 0 ; i < N; i++) {
            input = reader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input, " ");
            input = tokenizer.nextToken();
            if(input.equals("push")) {
                int data = Integer.parseInt(tokenizer.nextToken());
                push(stack, data);
            }
            else if(input.equals("pop")) {
                pop(stack);
            }
            else if(input.equals("size"))
                size(stack);
            else if(input.equals("empty"))
                empty(stack);
            else if(input.equals("top"))
                top(stack);
            //scanner.nextLine();
        }
    }

    public static void push(List stack, Integer X) {
        stack.add(X);
    }

    public static void pop(List stack) {
        if(stack.isEmpty())
            System.out.println("-1");
        else {
            System.out.println(stack.get(stack.size()-1));
            stack.remove(stack.size()-1);
        }
    }

    public static void size(List stack) {
        System.out.println(stack.size());
    }

    public static void empty(List stack) {
        if(stack.isEmpty())
            System.out.println("1");
        else

            System.out.println("0");
    }

    public static void top(List stack) {
        if(stack.isEmpty())
            System.out.println("-1");
        else
            System.out.println(stack.get(stack.size()-1));
    }
}