/*
1. 알파벳 입력
2. 알파벳 개수 계산
    2-1. 문자 단위로 탐색하면서 탐색위치 문자와 다음에 올 문자를 조합했을 때 크로아티아 알파벳인 경우 하나의 문자로 계산
<변환된 크로아티아 알파벳>
        č	c=
        ć	c-
        dž	dz=
        đ	d-
        lj	lj
        nj	nj
        š	s=
        ž	z=
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 알파벳 입력
        String input = br.readLine();
        
        int len = input.length(); // 입력한 알파벳의 길이
        int count = 0; // 리턴할 결과
        
        // 2. 알파벳 개수 계산
        for(int i = 0; i < len; i++){
            char tmp = input.charAt(i); // 탐색할 문자
            
            //2-1. 문자 단위로 탐색하면서 탐색위치 문자와 다음에 올 문자를 조합했을 때 크로아티아 알파벳인 경우 하나의 문자로 계산
            if(tmp == 'c' && i < len-1){ // 입력한 문자가 'c'인 경우
                if(input.charAt(i+1) == '=' || input.charAt(i+1) == '-'){
                    i++; // 현재 탐색위치와 그 다음 문자가 하나의 알파벳이므로 현재 탐색위치의 다음 위치는 건너뛴다.
                }
            }
            
            else if(tmp == 'd' && i < len-1){
                if(input.charAt(i+1) == '-'){ // d-인 경우
                    i++;
                } 
                // dz=인 경우
                else if(input.charAt(i+1) == 'z' && i < len-2){
                    if(input.charAt(i+2) == '='){
                        i+=2;
                    }
                }
            }
            
            else if((tmp == 'l' || tmp == 'n') && i < len-1){ // 'l'이나 'n'인 경우
                if(input.charAt(i+1) == 'j'){
                    i++;
                }
            }
            
            else if((tmp == 's' || tmp == 'z') && i < len-1){ // 's'나 'z'인 경우
                if(input.charAt(i+1) == '='){
                    i++;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}