/*
1. 수열의 크기 N 입력
2. N개의 수 입력
3. 테스트 케이스 수 M 입력
4. S, E 입력
5. 4번의 입력을 바탕으로 펠린드롬 여부 확인
6. 결과 출력(펠린드롬인 경우 1, 아닌 경우 2출력)
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // 1. 수열의 크기 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. N개의 수 입력
        int[] num = new int[N]; // 입력받은 숫자를 담을 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 테스트 케이스 수 M 입력
        int M = Integer.parseInt(br.readLine());
        
        // 4. S, E 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            // 5. 4번의 입력을 바탕으로 펠린드롬 여부 확인
            if(calcPalindrome(num, S-1, E-1)){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
            
        }
        // 6. 결과 출력(펠린드롬인 경우 1, 아닌 경우 2출력)
        System.out.println(sb);
    }
    
    // 펠린드롬 여부를 파악하는 메서드
    static boolean calcPalindrome(int[] num, int startIndex, int endIndex){
        while(startIndex < endIndex){
            // 첫 번째 인덱스의 문자와 마지막 인덱스의 문자가 다른 경우 false 리턴
            if(num[startIndex] != num[endIndex]){
                return false;
            }
            // 첫 번째 인덱스의 문자와 마지막 인덱스의 문자가 같은 경우 다음 문자 탐색
            startIndex++;
            endIndex--;
        }
        return true;
    }
}