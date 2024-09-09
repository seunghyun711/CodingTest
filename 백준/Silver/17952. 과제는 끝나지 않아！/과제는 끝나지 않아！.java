/*
1. N 입력
2. 과제 정보 입력(1, 배점, 소요시간)
3. 과제 시간 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int score = 0; // 총 과제 점수
        
        Stack<Homework> hwStack = new Stack<>(); // Homework 객체를 담을 스택 선언
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
      
        // 2. 과제 정보 입력(1, 배점, 소요시간)
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int isExistedHw = Integer.parseInt(st.nextToken()); // 과제 유무
            if(isExistedHw == 1){ // 과제가 있는 경우
                int point = Integer.parseInt(st.nextToken()); // 배점
                int time = Integer.parseInt(st.nextToken()); // 소요시간
                if(time == 1){ // 과제를 모두 완료한 경우 과제의 총 과제 점수에 현재 과제 점수를 더한다.
                    score += point;
                }else{ // 새로 들어온 과제를 스택에 저장
                    hwStack.push(new Homework(point, time - 1)); // 새로 들어온 순간 과제를 진행했기 때문에 time-1
                }
            }
            else if(!hwStack.isEmpty()){ // 과제가 새로 들어오지 않고, 기존과제를 진행하는 경우
                Homework hw = hwStack.peek(); // 현재 과제 스택에 있는 과제 객체 추출
                hw.time--; // 과제 진행
                if(hw.time == 0){ // 과제가 왼료된 경우
                    hwStack.pop(); // 과제 스택에서 제거
                    score += hw.point; // 총 과제 점수에 완료한 과제 점수를 더한다.
                }
            }
            
        }
        // 4. 결과 출력
        System.out.println(score);
    }
}

// 과제 클래스
class Homework{
    int point; // 배점
    int time; // 소요시간
        
    public Homework(int point, int time){
        this.point = point;
        this.time = time;
    }
}
