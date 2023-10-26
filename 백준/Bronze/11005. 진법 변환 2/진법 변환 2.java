/*
1. N, B 입력
2. N % B를 반복하여 B진법으로 변환.
    2-1. N % B  >= 10 이면 (N%B) + 'A' - 10
    2-2. N % B < 10이면 그대로 출력
3. 변환된 값들을 담은 리스트를 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. N, B 입력
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        List<Character> list = new ArrayList<>();
        
        // 2. N % B를 반복하여 B진법으로 변환.
        while(N > 0){
            // 2-1. N % B  >= 10 이면 (N%B) + 'A' - 10
            if(N % B >= 10){ 
                list.add((char)(N % B - 10 + 'A'));
            }
            // 2-2. N % B < 10이면 그대로 출력
            else{
                list.add((char)(N % B + '0'));
            }
            N /= B;
        }
        
        // 3. 변환된 값들을 담은 리스트를 출력
        for(int i = list.size() - 1; i >= 0; i--){
            System.out.print(list.get(i));
        }
        
    }
}