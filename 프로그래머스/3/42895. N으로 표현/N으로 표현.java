import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // 초기화: 각 자릿수에 해당하는 숫자 추가
        for (int i = 1; i <= 8; i++) {
            StringBuilder num = new StringBuilder();
            for (int j = 0; j < i; j++) {
                num.append(N);
            }
            dp.get(i).add(Integer.parseInt(num.toString()));
        }

        // 사칙연산을 통해 나올 수 있는 숫자 조합 계산
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int x : dp.get(j)) {
                    for (int y : dp.get(i - j)) {
                        dp.get(i).add(x + y);
                        dp.get(i).add(x - y);
                        dp.get(i).add(x * y);
                        if (y != 0) {
                            dp.get(i).add(x / y);
                        }
                    }
                }
            }
        }

        // 최솟값이 8보다 크면 -1을 반환
        for (int i = 1; i <= 8; i++) {
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }

}