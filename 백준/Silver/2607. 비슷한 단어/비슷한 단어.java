import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String standard = br.readLine();
        int[] standardArr = new int[26];

        for (int i = 0; i < standard.length(); i++) {
            standardArr[standard.charAt(i) - 65]++;
        }

        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] count = new int[26];
            String temp = br.readLine();

            for (int j = 0; j < temp.length(); j++)
                count[temp.charAt(j) - 65]++;

            int different = 0;
            for (int j = 0; j < 26; j++) {
                if (count[j] != standardArr[j]) {
                    different += Math.abs(count[j] - standardArr[j]);
                }

            }

            if (different == 0) // 같은 경우
                result++;
            else if(Math.abs(standard.length() - temp.length()) == 1 && different == 1) {
                // 하나를 뺴거나 더하는 경우
                // 길이는 하나만 차이나야 하고, 알파벳 개수도 한 개만 차이나야 함.
                result++;
            } else if(temp.length() == standard.length() && different == 2){
                // 바꾸는 경우
                // 길이는 같아야 하고, 다른 것은 차이가 총 2가 되어야함.
                result++;
            }

        }

        System.out.println(result);
    }
}