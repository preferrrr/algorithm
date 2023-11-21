import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = new String[5];

        arr[1] = br.readLine();
        arr[2] = br.readLine();
        arr[3] = br.readLine();
        arr[4] = br.readLine();

        int k = Integer.parseInt(br.readLine());

        for (int t = 0; t < k; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            //dir : 1이면 시계 right, -1이면 반시계 left

            int temp = dir;
            List<Integer> list = new ArrayList<>();
            for (int i = num - 1; i >= 1; i--) {
                if (arr[i].charAt(2) != arr[i + 1].charAt(6)) {
                    if (temp == 1) {
                        list.add(-1);
                        temp = -1;
                    } else {
                        list.add(1);
                        temp = 1;
                    }
                } else break;
            }

            int index = num - 1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 1) {
                    arr[index] = right(arr[index]);
                } else {
                    arr[index] = left(arr[index]);
                }
                index--;
            }

            temp = dir;
            List<Integer> list2 = new ArrayList<>();
            for (int i = num + 1; i <= 4; i++) {
                if (arr[i].charAt(6) != arr[i - 1].charAt(2)) {
                    if (temp == 1) {
                        list2.add(-1);
                        temp = -1;
                    } else {
                        list2.add(1);
                        temp = 1;
                    }
                } else break;
            }

            index = num + 1;
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i) == 1) {
                    arr[index] = right(arr[index]);
                } else {
                    arr[index] = left(arr[index]);
                }
                index++;
            }

            if (dir == 1) {
                arr[num] = right(arr[num]);
            } else {
                arr[num] = left(arr[num]);
            }

        }

        int result = 0;
        if (arr[1].charAt(0) == '1')
            result += 1;
        if (arr[2].charAt(0) == '1')
            result += 2;
        if (arr[3].charAt(0) == '1')
            result += 4;
        if (arr[4].charAt(0) == '1')
            result += 8;

        System.out.println(result);
    }

    static String left(String word) { //반시계, -1
        String result = word.substring(1, 8) + word.charAt(0);
        return result;
    }

    static String right(String word) { //시계, 1
        String result = word.charAt(7) + word.substring(0, 7);
        return result;
    }


}