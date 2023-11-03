import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        int max = 0;
        //가로 최대값
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    count++;
                    if (count > max)
                        max = count;
                } else if (arr[i][j] != arr[i][j + 1]) {
                    count = 1;
                }
            }
        }
        //세로 최대값
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i][j] == arr[i + 1][j]) {
                    count++;
                    if (count > max)
                        max = count;
                } else if (arr[i][j] != arr[i + 1][j])
                    count = 1;
            }
        }

        //가로로 바꾸고 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    //바꾸기
                    char temp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = temp;
                    //검사

                    //바뀐거 가로 최대 체크
                    int count = 1;
                    for (int k = 0; k < n - 1; k++) {
                        if (arr[i][k] == arr[i][k + 1]) {
                            count++;
                            if (max < count)
                                max = count;
                        } else count = 1;
                    }

                    //바뀐거 세로 체크
                    count = 1;
                    for (int k = 0; k < n - 1; k++) {
                        if (arr[k][j] == arr[k + 1][j]) {
                            count++;
                            if (max < count)
                                max = count;
                        } else count = 1;
                    }

                    //바뀐거 세로 체크
                    count = 1;
                    for (int k = 0; k < n - 1; k++) {
                        if (arr[k][j + 1] == arr[k + 1][j + 1]) {
                            count++;
                            if (max < count)
                                max = count;
                        } else count = 1;
                    }

                    //바꾸기
                    temp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = temp;
                }
            }
        }

        //세로로 바꾸고 검사
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i][j] != arr[i + 1][j]) {
                    //바꾸기
                    char temp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = temp;
                    //검사

                    //바뀐거 세로 최대 체크
                    int count = 1;
                    for (int k = 0; k < n - 1; k++) {
                        if (arr[k][j] == arr[k + 1][j]) {
                            count++;
                            if (max < count)
                                max = count;
                        } else count = 1;
                    }

                    //바뀐거 세로 체크
                    count = 1;
                    for (int k = 0; k < n - 1; k++) {
                        if (arr[i][k] == arr[i][k + 1]) {
                            count++;
                            if (max < count)
                                max = count;
                        } else count = 1;
                    }

                    //바뀐거 세로 체크
                    count = 1;
                    for (int k = 0; k < n - 1; k++) {
                        if (arr[i + 1][k] == arr[i + 1][k + 1]) {
                            count++;
                            if (max < count)
                                max = count;
                        } else count = 1;
                    }

                    //바꾸기
                    temp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = temp;
                }
            }
        }

        System.out.println(max);


    }
}