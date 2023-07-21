import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Info implements Comparable<Info> {
        long num=0;
        boolean first=false;


        @Override
        public int compareTo(Info o) {
            if(num>o.num){
                return 1;
            }
            if(num==o.num){
                return 0;
            }
            else
            {
                return -1;
            }
        }//단순하게 빼버렸다가 오버플로우 문제가 발생했다. java에서 오버플로우 조심하도록 하자
    }
    static public void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        Info cal[]=new Info[10];
        for(int i=0;i<10;i++){
            cal[i]=new Info();
        }
        for(int t=0;t<n;t++) {
            String s1 = bf.readLine();
            cal[(int) (s1.charAt(0) - 'A')].num += Math.pow(10, s1.length() - 1 - 0);
            cal[(int) (s1.charAt(0) - 'A')].first=true;//맨 처음 나온 수의 경우 처음 나왔다고 표시해둔다
            for (int i = 1; i < s1.length(); i++) {
                cal[(int) (s1.charAt(i) - 'A')].num += Math.pow(10, s1.length() - 1 - i);//각 자리의 수에 해당하는 10의 거듭제곱을 더해준다
            }
        }
        long ans=0;
        Arrays.sort(cal);//정렬한뒤
        int used[]=new int[10];

        for(int i=0;i<10;i++){
            if(cal[i].first){//만약 첫번째 자리 수 였을 경우
                for(int j=1;j<10;j++){//1이상의 수 중 가장 작은 수를 곱해서 더해준다.
                    if(used[j]==0){
                        ans+=cal[i].num*(long)j;
                        used[j]=1;
                        break;
                    }
                }
            }
            else {
                for(int j=0;j<10;j++){
                    if(used[j]==0){//첫자리가 아닐 경우 가장 작은 수를 더해준다.
                        ans+=cal[i].num*(long)j;
                        used[j]=1;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}