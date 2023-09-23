/*
1. 문자열 입력
2. switch - case문으로 각 문자별 걸리는 시간 구해서 더하기
 */
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 문자열 입력
        String s = br.readLine();
        int time = 0; // 총 걸리는 시간

        for (int i = 0; i < s.length(); i++) {
            // 2. switch - case문으로 각 문자별 걸리는 시간 구해서 더하기
            switch (s.charAt(i)) {
                case 'A': case 'B': case 'C':
                    time += 3;
                    break;

                case 'D': case 'E': case 'F':
                    time += 4;
                    break;

                case 'G': case 'H': case 'I':
                    time += 5;
                    break;

                case 'J': case 'K': case 'L':
                    time += 6;
                    break;

                case 'M': case 'N': case 'O':
                    time += 7;
                    break;

                case 'P': case 'Q': case 'R': case 'S':
                    time += 8;
                    break;

                case 'T': case 'U': case 'V':
                    time += 9;
                    break;

                case 'W': case 'X': case 'Y': case 'Z':
                    time += 10;
                    break;
            }
        }
        System.out.println(time);
    }
}