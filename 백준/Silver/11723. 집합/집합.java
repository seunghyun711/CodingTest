import java.io.*;
import java.util.*;

/*
1. 수행할 연산의 수 입력
2. 연산 및 숫자 입력
3. 각 연산에 맞는 로직 수행
4. 결과 출력
*/
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>(); // 집합 선언
        
        /* System.out.println은 동기화가 적용되어 있어 오버헤드 발생 가능성이 있음 
           따라서 결과를 매번 System.out.println()으로 출력하지 않고, StringBuilder를 통해
           버퍼에 결과를 모아두고 한 번에 출력하는 방식으로 해결함
        */ 
        StringBuilder sb = new StringBuilder();
      
        int num; // 연산할 숫자
        
        // 1. 수행할 연산의 수 입력
        int M = Integer.parseInt(br.readLine());
        
        // 2. 연산 및 숫자 입력
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken(); // 입력받은 연산자
            
            switch(operator){
                case "add": // S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                    
                case "remove": // S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                    
                case "check": // S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
                    num = Integer.parseInt(st.nextToken());
                    if(set.contains(num)){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                    
                case "toggle": // S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
                    num = Integer.parseInt(st.nextToken());
                    if(set.contains(num)){
                        set.remove(num);
                    }else{
                        set.add(num);
                    }
                    break;
                    
                case "all": // S를 {1, 2, ..., 20} 으로 바꾼다.
                    set = new HashSet<>();
                    for(int j = 1; j <= 20; j++){
                        set.add(j);
                    }
                    break;
                
                case "empty": // S를 공집합으로 바꾼다.
                    set.clear();
                    break;
            }
        }
        // 4. 결과 출력
        System.out.println(sb.toString());
    }
}