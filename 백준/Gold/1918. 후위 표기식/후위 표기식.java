/*
1. 중위 표기식 입력
2. 규칙에 따라 입력받은 중위 표기식을 후위 표기식으로 변경
3. 결과 출력
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        // 1. 중위 표기식 입력
        String infix = br.readLine();
        
        // 2. 규칙에 따라 입력받은 중위 표기식을 후위 표기식으로 변경
        for(int i = 0; i < infix.length(); i++){
            char tmp = infix.charAt(i);
            // 연산자 외의 입력은 바로 출력
            if('A' <= tmp && 'Z' >= tmp){
                sb.append(tmp);
            }
            
            // 여는 괄호('(')가 나오면 스택에 저장
            else if(tmp == '('){
                stack.add(tmp);
            }
            
            // 닫는 괄호(")")가 나오면 여는 괄호("(")가 나올 때까지 스택의 요소 출력
            else if(tmp == ')'){
                while(!stack.isEmpty()){
                    if(stack.peek() == '('){
                        stack.pop(); // 괄호는 출력에 들어가지 않아야 하기 때문에 pop()
                        break;
                    }
                    sb.append(stack.pop());
                }
            }
            
            // 연산자를 스택에 넣을 때 이미 스택에 들어있는 연산자가 더 우선순위가 높거나 같은 연산자가 있다면 해당 연산자를 먼저 꺼냄
            else {
                while(!stack.isEmpty() && checkPriority(stack.peek()) <= checkPriority(tmp)){
                    sb.append(stack.pop());
                }
                stack.add(tmp);
            }            
        }
        
        // 스택에 남아있는 요소를 모두 꺼냄
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        // 3. 결과 출력
        System.out.println(sb);
    }
    
    // 스택 요소의 우선순위를 구하는 메서드(숫자가 작을수록 높은 우선순위)
    static int checkPriority(char c){
        if(c == '('){
            return 2;
        }else if(c == '+' || c == '-'){
            return 1;
        }else{
            return 0;
        }
    }
}