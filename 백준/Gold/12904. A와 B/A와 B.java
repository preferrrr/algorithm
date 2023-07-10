import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        //A를 추가
        //뒤집고 B를 추가

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        StringBuilder end = new StringBuilder(br.readLine());


        while(start.length() != end.length()) {
            if(end.charAt(end.length()-1) == 'A')
                end.delete(end.length()-1, end.length());

            else if(end.charAt(end.length()-1) == 'B')
                end.delete(end.length()-1, end.length()).reverse();
        }

        if(start.equals(end.toString()))
            System.out.println(1);
        else
            System.out.println(0);

    }

}