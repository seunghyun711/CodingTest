/*
1. 이름 입력
2. 두 개의 이름 조합
3. 조합된 이름의 각 문자의 획수를 큐에 삽입
4. 이름 궁합 계산
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 1. 이름 입력
        String myName = br.readLine();
        String herName = br.readLine();
        
        // 2. 두 개의 이름 조합
        int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        String comb = ""; // 두 이름을 조합한 문자열
        for(int i = 0; i < myName.length(); i++){
            comb += myName.charAt(i);
            comb += herName.charAt(i);
        }
        
        // 3. 조합된 이름의 각 문자의 획수를 큐에 삽입
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < comb.length(); i++){
            q.add(alphabet[comb.charAt(i) - 'A']);
        }
        
        // 4. 이름 궁합 계산
        int count = comb.length() - 1;
        while(q.size() > 2){
            for(int i = 0; i < count; i++){
                int first = q.poll();
                int second = q.peek();
                q.add((first + second) % 10);
            }
            q.poll(); // 한 턴의 계산이 종료되면 큐의 맨 앞 요소를 삭제(두 번쨰 요소부터 1차 계산 후의 결과가 큐에 담겨있음)
            count--;
        }
        int num1 = q.poll();
        int num2 = q.poll();
        sb.append(num1).append(num2);
        
        // 5. 결과 출력
        System.out.println(sb);
    }
}