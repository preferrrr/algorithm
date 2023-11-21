import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 0 ; test < t; test++) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            String result = solve(func, n, arr);
            sb.append(result + "\n");
        }

        System.out.print(sb);
    }

    static String solve(String func, int n, String arr) {

        if(n == 0 && func.contains("D")) {
            return "error";
        }
        String[] temp = arr.substring(1, arr.length() - 1).split(",");

        Deque<String> deque = new ArrayDeque<>();
        for(int i = 0 ; i < temp.length; i++) {
            deque.add(temp[i]);
        }

        boolean flag = false; // false이면 앞에꺼 poll, true면 뒤에꺼 poll

        for(int i = 0; i < func.length(); i++) {
            if(func.charAt(i) == 'R') {
                if(!flag)
                    flag = true;
                else
                    flag = false;
            } else {
                if(deque.size() == 0)
                    return "error";
                else {
                    if(!flag)
                        deque.pollFirst();
                    else deque.pollLast();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        if(!flag) {
            while(!deque.isEmpty())
                result.append(deque.pollFirst() + ",");
        } else {
            while(!deque.isEmpty())
                result.append(deque.pollLast() + ",");
        }

        if(result.length() > 1)
            result.delete(result.length()-1, result.length());

        result.append("]");

        return result.toString();



    }


}