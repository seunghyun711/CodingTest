/*
1. 세 변의 길이 입력
2. '가장 긴 변의 길이 < 두 변의 길이'인 경우 조건에 따라 삼각형의 종류 출력
3. '가장 긴 변의 길이 >= 두 번의 길이'인 경우 Invalid 출력
4. 0 0 0이 입력된 경우 프로그램 종료
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3]; // 세 변의 길이를 담을 배열
        
        while(true){
            // 1. 세 변의 길이 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            
            // 4. 0 0 0이 입력된 경우 프로그램 종료
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0){
                break;
            }
            
            Arrays.sort(arr); // 세 변의 길이를 담은 배열 정렬
            
            // 2. '가장 긴 변의 길이 < 두 변의 길이'인 경우 조건에 따라 삼각형의 종류 출력
            if(arr[2] < (arr[0] + arr[1])){
                // Equilateral :  세 변의 길이가 모두 같은 경우
                if(arr[0] == arr[1] && arr[0] == arr[2] && arr[1] == arr[2]){
                    System.out.println("Equilateral");
                }
                // Isosceles : 두 변의 길이만 같은 경우
                else if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]){
                    System.out.println("Isosceles");
                }
                // Scalene : 세 변의 길이가 모두 다른 경우
                else{
                    System.out.println("Scalene");
                }
                // 3. '가장 긴 변의 길이 >= 두 번의 길이'인 경우 Invalid 출력
            }else {
                System.out.println("Invalid");
            }
            
            
        }
    }
}