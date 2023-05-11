import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        dot A = new dot();
        dot B = new dot();
        dot C = new dot();

        A.x = scanner.nextDouble();
        A.y = scanner.nextDouble();
        B.x = scanner.nextDouble();
        B.y = scanner.nextDouble();
        C.x = scanner.nextDouble();
        C.y = scanner.nextDouble();

        // ab,ac / ba,bc / ca,cb
        // B - A = C - B 이면 -1 반환


        System.out.println(pararell(A, B, C));

    }

    public static double pararell(dot A, dot B, dot C) {

//        if ((A.x == B.x && B.x == C.x) || ((((B.y - A.y) / (B.x - A.x)) - ((C.y - B.y) / (C.x - B.x))) < 0.000000001)) {
//            return -1;
//        }

        if (((B.y-A.y) * (C.x-B.x)) == ((C.y - B.y) * (B.x - A.x)))
            return -1;
        double first = Math.sqrt(Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2))
                + Math.sqrt(Math.pow(A.x - C.x, 2) + Math.pow(A.y - C.y, 2));

        double second = Math.sqrt(Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2))
                + Math.sqrt(Math.pow(B.x - C.x, 2) + Math.pow(B.y - C.y, 2));


        double third = Math.sqrt(Math.pow(A.x - C.x, 2) + Math.pow(A.y - C.y, 2))
                + Math.sqrt(Math.pow(B.x - C.x, 2) + Math.pow(B.y - C.y, 2));


        double max = Math.max(Math.max(first, second), third);
        double min = Math.min(Math.min(first, second), third);
        return 2 * (max - min);


    }


}


class dot {
    double x;
    double y;
}