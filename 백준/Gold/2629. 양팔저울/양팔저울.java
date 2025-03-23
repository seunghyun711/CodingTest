/*
1. 추의 개수 입력
2. 추의 무게 입력
3. 구슬의 개수 입력
4. 구슬의 무게 입력
5. dp를 이용해 구슬의 무게 파악 가능 여부 계산
6. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int chuNum; // 추의 개수
    static int[] chuWeight; // 추의 무게
    static boolean[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. 추의 개수 입력
        chuNum = Integer.parseInt(br.readLine());
        
        // 2. 추의 무게 입력
        chuWeight = new int[chuNum];
        dp = new boolean[chuNum + 1][40001];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < chuNum; i++){
            chuWeight[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 구슬의 개수 입력
        int beads = Integer.parseInt(br.readLine());
        
        // 4. 구슬의 무게 입력
        st = new StringTokenizer(br.readLine());
        int[] beadWeight = new int[beads];
        
        for(int i = 0; i < beads; i++){
            beadWeight[i] = Integer.parseInt(st.nextToken());
        }
        
        // 5. dp를 이용해 구슬의 무게 파악 가능 여부 계산
        findWeight(0, 0);
        
        for(int i = 0; i < beads; i++){
            if(dp[chuNum][beadWeight[i]]){
                sb.append("Y ");
            }else{
                sb.append("N ");
            }
        }
        
        // 6. 결과 출력
        System.out.println(sb);
    }
    
    static void findWeight(int chu, int weight){
        if(dp[chu][weight]){
            return;
        }
        dp[chu][weight] = true;
        
        if(chu == chuNum){
            return;
        }
        
        // 추를 올리지 않는 경우
        findWeight(chu + 1, weight);
        // 추를 왼쪽에 올리는 경우
        findWeight(chu + 1, weight + chuWeight[chu]);
        // 추를 오른쪽에 올리는 경우(현재 추가 있는 반대쪽에 다음 추를 올리는 경우)
        findWeight(chu + 1, Math.abs(weight - chuWeight[chu]));
    }
}