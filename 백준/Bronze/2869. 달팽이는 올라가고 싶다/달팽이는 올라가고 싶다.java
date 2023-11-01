/*
1. A,B,V 입력
2. V에 도달하기 하루 전은 (V-A) / (A-B) -> A-B 보다 적은 거리가 남을 경우를 처리하기 위해 하루 전 값을 구한다.
    2-1. (V-A) / (A-B)의 나머지가 0이 아닌 경우(아직 V에 도달하지 못한 경우) 일수 + 1
3. 2번을 통해 나온 날짜는 마지막 날을 고려하지 않은 날짜이기 때문에 일수 + 1
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. A,B,V 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 2. V에 도달하기 하루 전은 (V-A) / (A-B) -> A-B 보다 적은 거리가 남을 경우를 처리하기 위해 하루 전 값을 구한다.
        int count = (V-A) / (A-B);
        
        // 2-1. V / (A-B)의 나머지가 0이 아닌 경우(아직 V에 도달하지 못한 경우) 일수 + 1
        if((V-A) % (A-B) != 0){
            count++;
        }
        
        // 3. 2번을 통해 나온 날짜는 마지막 날을 고려하지 않은 날짜이기 때문에 일수 + 1
        System.out.println(count+1); 
    }
}