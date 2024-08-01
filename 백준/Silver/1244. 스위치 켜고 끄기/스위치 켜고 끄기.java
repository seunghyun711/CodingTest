/*
1. 스위치 개수 입력
2. 스위치 개수 크기의 배열 선언
3. 스위치 상태 입력 및 2번에서 선언한 배열에 저장
4. 학생 수 입력
5. 각 학생의 성별, 주어진 숫자 입력
6. 성별과 주어진 숫자에 따라 스위치 상태 변경
7. 스위치 상태 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 스위치 개수 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 스위치 개수 크기의 배열 선언
        int[] switchStatus = new int[N];
        
        // 3. 스위치 상태 입력 및 2번에서 선언한 배열에 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }
        
        // 4. 학생 수 입력
        int students = Integer.parseInt(br.readLine());
        
        // 5. 각 학생의 성별, 주어진 숫자 입력
        for(int i = 0; i < students; i++){
            st = new StringTokenizer(br.readLine());
            // 6. 성별과 주어진 숫자에 따라 스위치 상태 변경
            int gender = Integer.parseInt(st.nextToken()); // 성별
            int num = Integer.parseInt(st.nextToken()); // 숫자
            
            // 남자인 경우
            if(gender == 1){
                maleSwitchStatus(switchStatus, num);
            }
            // 여자인 경우
            else if(gender == 2){
                femaleSwitchStatus(switchStatus, num);
            } 
        } 
        
        // 7. 스위치 상태 출력
        for(int i = 0; i < switchStatus.length; i++){
            System.out.print(switchStatus[i] + " ");
            // 스위치 상태는 20개씩 출력 20개가 넘어가면 줄바꿈
            if((i+1) % 20 == 0){
                System.out.println();
            }
        }
    }
    
    // 성별이 남자인 경우의 스위치 변경 메서드
    static void maleSwitchStatus(int[] switchStatus, int num){
        for(int i = 0; i < switchStatus.length; i++){
            // 현재 스위치의 번호가 num의 배수인 경우 스위치 상태 변경(0 or 1)
            if((i + 1) % num == 0){
                switchStatus[i] = switchStatus[i] == 0 ? 1 : 0; 
            }
        }
    }
    
    // 성별이 여자인 경우의 스위치 변경 메서드
    static void femaleSwitchStatus(int[] switchStatus, int num){
        switchStatus[num - 1] = switchStatus[num - 1] == 0 ? 1 : 0; // 현재 위치의 스위치 상태 변경
        for(int i = 0; i < switchStatus.length; i++){
            // 현재 스위치 위치에서 대칭되는 위치의 스위치가 스위치 개수의 범위를 넘어가는 경우 연산 종료
            if(((num - 1 - i) < 0) || ((num - 1 + i) >= switchStatus.length)){
                break;
            }
            // 현재 위치에서 대칭되는 위치의 스위치 상태가 같은 경우 스위치 상태 변경
            if(switchStatus[num - 1 - i] == switchStatus[num - 1 + i]){
                switchStatus[num - 1 - i] = switchStatus[num - 1 - i] == 0 ? 1 : 0;
                switchStatus[num - 1 + i] = switchStatus[num - 1 + i] == 0 ? 1 : 0;
            }else{ // 대칭되는 위치의 스위치 상태가 다른 경우 연산 종료
                break;
            }
        }
    }
}