import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String temp = br.readLine();
        int[] start = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = temp.charAt(i) - 48;
        }

        temp = br.readLine();
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            end[i] = temp.charAt(i) - 48;
        }

        //0번 스위치를 눌렀을 때와 누르지 않았을 때로 나눔

        int[] a = zeroChange(start.clone());
        int[] b = start.clone();

        int resultA = 1;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] != end[i - 1]) {
                change(a, i);
                resultA++;
            }
        }

        int resultB = 0;
        for (int i = 1; i < n; i++) {
            if (b[i - 1] != end[i - 1]) {
                change(b, i);
                resultB++;
            }
        }

        if(a[n-1] != end[n-1])
            resultA = -1;
        if(b[n-1] != end[n-1])
            resultB = -1;

        if(resultA != -1 && resultB != -1)
            System.out.println(Math.min(resultA, resultB));
        else if(resultA == -1 && resultB != -1)
            System.out.println(resultB);
        else if(resultA != -1 && resultB == -1)
            System.out.println(resultA);
        else
            System.out.println(-1);

        
    }

    public static int[] zeroChange(int[] a) {
        if (a[0] == 0)
            a[0] = 1;
        else a[0] = 0;

        if (a[1] == 0)
            a[1] = 1;
        else a[1] = 0;

        return a;
    }

    public static void change(int[] a, int i) {
        if (a[i - 1] == 0)
            a[i - 1] = 1;
        else a[i - 1] = 0;
        if (a[i] == 0)
            a[i] = 1;
        else a[i] = 0;
        if (i != a.length - 1) {
            if (a[i + 1] == 0)
                a[i + 1] = 1;
            else a[i + 1] = 0;
        }
    }

}