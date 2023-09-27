/*
1. 단어 입력
2. charAt()을 통해 입력받은 단어를 역순으로 배치
3. 입력한 단어와 역순으로 배치한 단어를 비교(equals())하여 같으면 1, 다르면 0 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 단어 입력
        String s = br.readLine();
        
        // 2. charAt()을 통해 입력받은 단어를 역순으로 배치
        String reverse = ""; // 역순으로 재배치한 단어
        for(int i = s.length()-1; i >= 0; i--){
            reverse += s.charAt(i);
        }
        
        // 3. 입력한 단어와 역순으로 배치한 단어를 비교(equals())하여 같으면 1, 다르면 0 출력
        if(s.equals(reverse)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}