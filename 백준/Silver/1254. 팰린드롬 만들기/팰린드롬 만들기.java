/*
1. 문자열 입력
2. 2. 1번에서 입력한 문자열을 앞에서부터 한 문자씩 잘른 문자열의 가장 첫 인덱스 문자와 가장 끝 인덱스의 문자와 비교
3. 2번을 통해 펠린드롬을 만족시키기 위한 필요 문자의 개수를 계산하여 기존 문자열에 더하고 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 문자열 입력
        String str = br.readLine();
        
        // 2. 1번에서 입력한 문자열을 앞에서부터 한 문자씩 잘른 문자열의 가장 첫 인덱스 문자와 가장 끝 인덱스의 문자와 비교
        int conditionStrLen = 0; // 펠린드롬을 만족시키기 위한 필요 문자의 개수
        for(int i = 0; i < str.length(); i++){
            if(calcPalindrome(str.substring(i))){ // 펠린드롬 여부를 파악
                conditionStrLen = i; // 펠린드롬을 만족시키기 위한 필요 문자의 개수
                break;
            }
        }
        
        // 3. 2번을 통해 펠린드롬을 만족시키기 위한 필요 문자의 개수를 계산하여 기존 문자열에 더하고 출력
        System.out.println(str.length() + conditionStrLen);
    }
    
    // 펠린드롬 여부를 확인하는 메서드
    static boolean calcPalindrome(String subStr){
        int startIndex = 0;
        int endIndex = subStr.length() - 1;
        
        while(startIndex < endIndex){
            // 첫 번째 인덱스의 문자와 마지막 인덱스의 문자가 다른 경우 false 리턴하고 
            if(subStr.charAt(startIndex) != subStr.charAt(endIndex)){ 
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}