/*
1을 중심으로 특정 범위의 숫자끼리 몇 번의 방을 거쳐야 하는지 겹침
1개 : 2~7번(6개)
2개 : 8~19번(12개)
3개 : 20~37번(18개)
...
거쳐야 하는 방의 개수가 1 증가 -> 해당 범위의 숫자의 개수는 6 * (거쳐야하는 방의 개수)씩 증가

1. 방 번호 입력 
2. 방 번호가 한 단위의 범위를 넘기면(1개방 -> 2개방) 거친 방의 개수 +1
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 방 번호 입력 
        int N = Integer.parseInt(br.readLine());
        
        int count = 1;
        int range = 2; // 방 범위(2번부터 시작)
        
        if(N == 1){ // 1번 이면 1 리턴
            System.out.println(1); 
        }else {
            // 2. 방 번호가 한 단위의 범위를 넘기면(1개방 -> 2개방) 거친 방의 개수 +1
            while(range <= N){
                range += (6 * count); // 거쳐야 하는 방의 개수가 1 증가 -> 해당 범위의 숫자의 개수는 6 * (거쳐야하는 방의 개수)씩 증가
                count++; // 거쳐야 하는 방의 개수 +1
            }
            System.out.println(count);
        }
    }
}
