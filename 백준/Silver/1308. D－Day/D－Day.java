import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startYear =  Integer.parseInt(st.nextToken());
        int startMonth = Integer.parseInt(st.nextToken());
        int startDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endYear =  Integer.parseInt(st.nextToken());
        int endMonth = Integer.parseInt(st.nextToken());
        int endDay = Integer.parseInt(st.nextToken());

        if(startYear+1000 < endYear || startYear+1000 == endYear && startMonth<endMonth
                ||startYear+1000==endYear && startMonth==endMonth && startDay<=endDay){
            System.out.println("gg");
        }else{
            int dDay = 0;
            while(true){
                startDay++;
                dDay++;

                if(startDay > 31 && (startMonth == 1 || startMonth == 3 || startMonth == 5 || startMonth ==7||
                        startMonth == 8 || startMonth == 10 || startMonth == 12 )){
                    startMonth++;
                    startDay = 1;
                }else if( startDay > 30 && (startMonth == 4 || startMonth == 6 || startMonth == 9 ||
                        startMonth == 11)){
                    startMonth++;
                    startDay = 1;
                }else if(startDay > 29 &&startMonth == 2 && check(startYear)){
                    startMonth++;
                    startDay = 1;
                }else if(startDay > 28 &&startMonth == 2 && !check(startYear)) {
                    startMonth++;
                    startDay = 1;
                }

                if (startMonth > 12) {
                    startYear++;
                    startMonth = 1;
                }

                if(startYear == endYear && startMonth == endMonth && startDay == endDay){
                    System.out.println("D-"+dDay);
                    break;
                }


            }

        }

    }

    public static boolean check(int year) { // 윤년

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
}