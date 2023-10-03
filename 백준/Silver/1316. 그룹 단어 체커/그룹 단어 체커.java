/*
1. 단어를 입력할 횟수 입력
2. 단어 입력
3. 그룹단어 판별 -> 판별을 위해 알파벳 개수 크기의 boolean 배열을 선언한다.
    3-1. 기준 정수형 변수와 문자열을 순회하며 탐색한 변수가 서로 다르면(서로 다른 문자인 경우)
    그룹 단어 판별 배열의 해당 문자열 인덱스를 ture로 바꾼다.
    3-2. 기준 정수형 변수와 문자열을 순회하며 탐색한 변수가 서로 같으면(서로 같은 문자인 경우)
    그룹 단어 판별 배열의 해당 문자열 인덱스를 false를 리턴한다.
4. 그룹단어 개수 출력
*/
import java.io.*;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        // 1. 단어를 입력할 횟수 입력
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        
        for(int i = 0; i < num; i++){
            if(verifiedGroup() == true){ // 그룹단어 검증 메서드가 true면 count 증가
                count++;
            }
        }
        System.out.println(count);
    }
    
    public static boolean verifiedGroup() throws IOException{
        boolean check[] = new boolean[26]; // 그룹 단어 판별할 배열
        int standard = 0; // 문자를 비교하기 위해 기준점이 되는 문자(ex 'a'를 97로 저장)
        // 2. 단어 입력
        String s = br.readLine(); 
        
        // 3. 그룹단어 판별
        for(int i = 0; i < s.length(); i++){
            int now = s.charAt(i); // 탐색 대상이 되는 문자
            
            /* 3-1. 기준 정수형 변수와 문자열을 순회하며 탐색한 변수가 서로 다르면(서로 다른 문자인 경우)
            그룹 단어 판별 배열의 해당 문자열 인덱스를 ture로 바꾼다.
            */
            if(standard != now){
                if(check[now - 'a'] == false){
                    check[now - 'a'] = true;
                    standard = now; // now 이후의 문자를 탐색해야 하기 때문에 standard를 now로 변경
                }
                
                /* 3-1. 기준 정수형 변수와 문자열을 순회하며 탐색한 변수가 서로 같으면(서로 같은 문자인 경우)
                그룹 단어 판별 배열의 해당 문자열 인덱스를 false를 리턴한다.
                */
                else{
                    return false;
                }
            }
        }
        return true;
    }
}