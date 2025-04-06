/*
1. N 입력
2. 각 빌딩의 높이 입력
3. 스택을 이용해 빌딩이 볼 수 있는 옥상의 개수 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0; 
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> st = new Stack<>();
        
        // 2. 각 빌딩의 높이 입력
        for(int i = 0; i < N; i++){
            int h = Integer.parseInt(br.readLine());
            
            // 3. 스택을 이용해 빌딩이 볼 수 있는 옥상의 개수 계산
            while(!st.isEmpty()){
                if(st.peek() <= h){ // 새로 입력받은 높이가 기존 스택에 있는 높이보다 큰 경우
                    st.pop();
                }else {
                    break;
                }
            }
            result += st.size();
            st.push(h);
        }
        
        // 4. 결과 출력
        System.out.println(result);
    }
}