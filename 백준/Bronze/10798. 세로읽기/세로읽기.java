/*
1. 2차원 배열 생성. 크기는 [5][15]
2. 5개의 단어 입력
3. 입력받은 단어를 1번에서 생성한 2차원 배열에 글자 단위로 인덱스에 삽입
4. 2차원 배열을 세로로 탐색해서 인덱스에 글자가 없으면 건너뛰고 바로 다음 인덱스 탐색
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 2차원 배열 생성. 크기는 [5][5]
        char[][] letter = new char[5][15]; // 입력할 글자를 담을 배열
        int max = 0; // 이볅한 단어의 최대길이를 담을 변수

        // 2. 5개의 단어 입력
        for(int i = 0; i < letter.length; i++){
            String s = br.readLine();

            // 3. 입력받은 단어를 1번에서 생성한 2차원 배열에 글자 단위로 인덱스에 삽입
            if(max < s.length()){
                max = s.length(); // 입력한 단어의 최대길이     
            }
            for(int j = 0; j < s.length(); j++){
                    letter[i][j] = s.charAt(j);
                }
        }

        // 4. 2차원 배열을 세로로 탐색해서 인덱스에 글자가 없으면 건너뛰고 바로 다음 인덱스 탐색
        for(int i = 0; i < max; i++){
            for(int j = 0; j < 5; j++){
                if(letter[j][i] == '\0'){
                    continue;
                }
                System.out.print(letter[j][i]);
            }
        }
    }
}