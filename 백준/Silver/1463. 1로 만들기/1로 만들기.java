import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1 : 0 , 2 : 1, 3 : 1 , 4 : 2, 5 : 3, 6 : 2, 7 : 3
        //8 : 3 , 9 : 2, 10 : 3 ,
        //12 : 4 2 1
        //11 : 10으로 만들고 score[10] = 4
        //11 : -1 -1로 9 만들고 score[9] = 4
        //
        //12 : 3으로 나눠지면 1+list[12/4] = 3
        //12 : 2로 나눠지면 1+list[12/6] = 3
        //12 : 1+list[11] 5

        //2로만 나눠짐
        //14 : 1+list[7] 4
        //14 : 1+list[13] 5

        //3으로만 나눠짐
        //15 : 1 + list[5]
        //15 : 1 + list[14]


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] count = new int[1000001];

        count[1] = 0;
        count[2] = 1;
        count[3] = 1;

        for (int i = 4; i <= n; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                count[i] = Math.min(Math.min(1 + count[i / 3], 1 + count[i / 2]), 1 + count[i - 1]);
            } else if (i % 3 == 0) {
                count[i] = Math.min(1 + count[i/3], 1 + count[i-1]);
            } else if(i % 2 == 0) {
                count[i] = Math.min(1 + count[i/2], 1 + count[i-1]);
            } else {
                count[i] = Math.min(1 + count[i-1], 2 + count[i-2]);
            }

        }

        System.out.println(count[n]);
    }
}