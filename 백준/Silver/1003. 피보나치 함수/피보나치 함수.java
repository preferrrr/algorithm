import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        //0 = 1 0
        //1 = 0 1
        //2 = 1 1
        //3 = 1 2
        //4 = 2 3
        //5 = 3 5
        int[][] list = new int[41][2];
        list[0][0] = 1;
        list[0][1] = 0;
        list[1][0] = 0;
        list[1][1] = 1;

        for(int i = 0; i <T; i++) {

            int n = scanner.nextInt();

            int k = 2;
            if(n == 0) {
                System.out.println(list[n][0] + " " + list[n][1]);
            }
            else if(n == 1) {
                System.out.println(list[n][0] + " " + list[n][1]);
            }
            else {
                while(k != n+1) {
                    list[k][0] = list[k-1][0] + list[k-2][0];
                    list[k][1] = list[k-1][1] + list[k-2][1];
                    k++;
                }
                System.out.println(list[k-1][0] + " " + list[k-1][1]);
            }

        }

    }

}