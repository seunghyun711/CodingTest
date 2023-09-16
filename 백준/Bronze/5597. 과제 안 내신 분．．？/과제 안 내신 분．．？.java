/*
1. 크기가 30인 정수형 배열 선언
2. 출석 입력(28번)
3. 출석 입력된 번호는 정수형 배열에 해당 인덱스에 번호 삽입
4. 출석 입력이 되지 않은 인덱스는 0이므로 값이 0인 인덱스를 찾아 출력
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System. in);
        
        // 1. 크기가 30인 정수형 배열 선언
        int[] attendanceList = new int[30]; // 출석 배열
        int[] absence = new int[2]; // 결석 인원 배열
        
        // 2. 출석 입력
        for(int i = 0; i < 28; i++){
            int attendance = sc.nextInt();
            sc.nextLine();
            // 3. 출석 입력된 번호는 정수형 배열에 해당 인덱스에 번호 삽입
            attendanceList[attendance - 1] = attendance;
        }
        
        //4. 출석 입력이 되지 않은 인덱스는 0이므로 값이 0인 인덱스를 찾아 출력
        for(int i = 0; i < attendanceList.length; i++){
            if(attendanceList[i] == 0){
                System.out.println(i+1);
            }
        }
    }
}