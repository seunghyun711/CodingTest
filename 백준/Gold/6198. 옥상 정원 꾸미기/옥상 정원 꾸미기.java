/*
1. 빌딩의 개수 입력
2. 각 빌딩의 높이 입력
3. 각 빌딩별 볼 수 있는 빌딩의 수 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int[] buildings;
    static long result = 0; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 빌딩의 개수 입력
        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        
        // 2. 각 빌딩의 높이 입력
        for(int i = 0; i < N; i++){
            buildings[i] = Integer.parseInt(br.readLine());
        }
        
        // 3. 각 빌딩별 볼 수 있는 빌딩의 수 계산
        for(int i = 0; i < N; i++){
            canSeeOksangs(buildings[i], i);
        }
        
        // 4. 결과 출력
        System.out.println(result);
    }
    
    // 볼 수 있는 빌딩의 옥상 수를 구하는 메서드
    static void canSeeOksangs(int building, int index){
        long count = 0;
        if(index == (N - 1)){ /// 현재 탐색 중인 빌딩이 마지막 빌딩인 경우
            return;
        }
        for(int i = index + 1; i < N; i++){
            if(building > buildings[i]){ // 현재 위치에서 i번째 빌딩의 옥상을 볼 수 있는 경우
                count++;
            }else{ // 현재 빌딩이 i번째 빌딩보다 작은 경우 탐색 종료
                break;
            }
        }
        
        // 벤치마킹이 가능한 빌딩의 수의 합 계산
        result += count;
    }
}