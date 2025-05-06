/*
1. 단어 입력
2. 단어를 세 단어로 나누고(세 단어로 나뉘는 모든 경우의 수를 탐색) 뒤집기
3. 2번을 통해 얻은 결과를 리스트에 저장
4. 리스트를 오름차순 정렬하여 가장 앞의 인덱스 요소를 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        
        // 1. 단어 입력
        String str = br.readLine();
        List<String> list = new ArrayList<>();
        
        // 2. 단어를 세 단어로 나누고(세 단어로 나뉘는 모든 경우의 수를 탐색) 뒤집기
        for(int i = 2; i < str.length(); i++){
            for(int j = 1; j < i; j++){
                String s1 = new StringBuilder(str.substring(0, j)).reverse().toString();
                String s2 = new StringBuilder(str.substring(j, i)).reverse().toString();
                String s3 = new StringBuilder(str.substring(i)).reverse().toString();
                
                // 3. 2번을 통해 얻은 결과를 리스트에 저장
                sb = new StringBuilder();
                list.add(String.valueOf(sb.append(s1).append(s2).append(s3)));
            }
        }
        
        // 4. 리스트를 오름차순 정렬하여 가장 앞의 인덱스 요소를 출력
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
