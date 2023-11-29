/*
1. 세 변의 길이 입력
2. '가장 긴 변의 길이 >= 나머지 두 변의 길이의 합'인 경우 
나머지 두 변의 길이의 합 - 1이 가장 긴 변의 길이가 된다.
3. '가장 긴 변의 길이 < 나머지 두 변의 길이의 합'인 경우 세 변의 길이를 더한다.
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3]; // 세 변의 길이를 담을 배열
        
        // 1. 세 변의 길이 입력
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr); // 배열내 요소를 오름차순으로 정렬
        
        // 2. '가장 긴 변의 길이 >= 나머지 두 변의 길이의 합'인 경우 
        if(arr[2] >= arr[0] + arr[1]){
            // 나머지 두 변의 길이의 합 - 1이 가장 긴 변의 길이가 된다.
            arr[2] = arr[0] + arr[1] - 1;
            System.out.println(arr[0] + arr[1] + arr[2]);
        }
        // 3. '가장 긴 변의 길이 < 나머지 두 변의 길이의 합'인 경우 세 변의 길이를 더한다.
        else{
            System.out.println(arr[0] + arr[1] + arr[2]);
        }
    }
}