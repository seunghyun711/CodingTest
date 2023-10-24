/*
1. N, B를 입력
2. 입력받은 문자열을 문자로 변환 후 범위에 따라 진법 변환 계산
    2-1. 입력받은 문자의 범위가 0~9 사이면 그대로 계산
    2-2. 입력받은 문자의 범위가 10 이상이면 값 변환 과정 수행
3. 왼쪽으로 자리 이동(제곱)
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. N, B를 입력
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        
        int result = 0; // 결과 
        int tmp = 1; // 자리이동을 위한 변수
       
        // 2. 입력받은 문자열을 문자로 변환 후 범위에 따라 진법 변환 계산
        for(int i = N.length()-1; i >= 0; i--){
            char c = N.charAt(i); // 입력받은 문자열을 문자로 변환
            // 2-1. 입력받은 문자의 범위가 0~9 사이면 그대로 계산
            if('0' <= c && '9' >= c){
                result += (c - '0') * tmp;
            }
            // 2-2. 입력받은 문자의 범위가 10 이상이면 값 변환 과정 수행
            else{
                result += (c - 'A' + 10) * tmp; // 10부터 A기 때문에 'A'를 빼고, 10을 더함
            }
            // 3. 왼쪽으로 자리 이동(제곱)
            tmp *= B; 
        }
        System.out.println(result);
    }
}