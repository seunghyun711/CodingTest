/*
1. N 입력
2. N X N 크기의 배열 생성
3. 쿠키 신체 입력
4. 머리 위치 탐색
5. 머리 위치를 기준으로 심장 위치 도출
6. 심장 위치를 기준으로 왼팔, 오른팔의 길이 계산
7. 심장 아래에 있는 허리의 길이 계산
8. 허리 끝 위치를 기준으로 왼다리, 오른다리의 길이 계산
9. 심장 위치, 각 신체의 길이 출력
★ 문제에서 배열의 시작위치가 (1,1)이고, 생성된 배열의 시작위치는 (0,0) 이므로
   심장 위치 출력시 도출된 위치에서 행과 열에 각각 +1씩 할 것
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. N X N 크기의 배열 생성
        String[][] board = new String[N][N];
        String[][] tmpBoard = new String[N][1]; // 입력받은 문자열을 한 문자씩 분리하기 위해 임시 배열 생성
        
        int headCount = 0; // 머리 위치를 찾기 위한 변수
        int headX = 0; // 머리가 위치한 행 
        int headY = 0; // 머리의 위치한 열
        
        // 3. 쿠키 신체 입력
        for(int i = 0; i < tmpBoard.length; i++){
            for(int j = 0; j < tmpBoard[0].length; j++){
                tmpBoard[i][j] = br.readLine();
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 문자열을 한 문자씩 분리하여 배열에 저장
                board[i][j] = String.valueOf(tmpBoard[i][0].charAt(j)); 
            }
        }
        
        // 4. 머리 위치 탐색(쿠키 배열에서 가장 첫 번째 "*"의 위치가 머리)
        for (int i = 0; i < N; i++) {
            // headCount == 1이라는 것은 머리 위치를 찾은 것이므로 headCount==1인 경우 탐색 종료
            if (headCount == 1) { 
                break;
            }
            for (int j = 0; j < N; j++) {
                if(board[i][j].equals("*")){ // 입력이 "*"인 경우 headCount 1 증가
                    headCount++;
                    headX = i;
                    headY = j;
                    break;
                }
            }
        }
        
        // 5. 머리 위치를 기준으로 심장 위치 도출
        int heartX = headX + 1;
        int heartY = headY;
        
        // 6. 심장 위치를 기준으로 왼팔, 오른팔의 길이 계산
        int[] armsLength = new int[2]; // 0번 인덱스는 왼팔의 길이, 1번 인덱스는 오른팔의 길이
        calcArmsLength(board, armsLength, heartX, heartY);
        
        // 7. 심장 아래에 있는 허리의 길이 계산
        int hurry = calcHurryLength(board, heartX, heartY); // 허리
        
        // 8. 허리 끝 위치를 기준으로 왼다리, 오른다리의 길이 계산
        int[] legsLength = new int[2]; // 0번 인덱스는 왼쪽 다리의 길이, 1번 인덱스는 오른쪽 다리의 길이
        calcLegsLength(board, hurry, legsLength, heartX, heartY);
        
        // 9. 심장 위치, 각 신체의 길이 출력
        heartX++;
        heartY++;
        System.out.println(heartX + " " + heartY);
        System.out.println(armsLength[0] + " " + armsLength[1] + " " + hurry + " " + legsLength[0] + " " + legsLength[1]);
    }
    
    // 팔의 길이를 계산하는 메서드
    static int[] calcArmsLength(String[][] board, int[] armsLength,
                                int heartX, int heartY){
        // 왼팔의 길이 계산
        for(int j = heartY - 1; j >= 0; j--){
            if(board[heartX][j].equals("*")){ // 현재위치가 "*"인 경우 팔의 길이 계산
                armsLength[0]++;
            }
            // 현재위치가 "_"인 경우 팔의 길이 계산이 끝난 것이기 때문에 반복문 종료
            else if(board[heartX][j].equals("_")){ 
                break;
            }
        }
        
        // 오른팔의 길이 계산
        for(int j = heartY + 1; j < board.length; j++){
            if(board[heartX][j].equals("*")){ // 현재위치가 "*"인 경우 팔의 길이 계산
                armsLength[1]++;
            }
            // 현재위치가 "_"인 경우 팔의 길이 계산이 끝난 것이기 때문에 반복문 종료
            else if(board[heartX][j].equals("_")){ 
                break;
            }
        }
        return armsLength;
    }
    
    // 허리 길이를 구하는 메서드
    static int calcHurryLength(String[][] board, int heartX, int heartY){
        int hurry = 0;
        for(int i = heartX + 1; i < board.length; i++){
            if(board[i][heartY].equals("*")){ // 현재위치가 "*"인 경우 허리의 길이 계산
                hurry++;
            }
            // 현재위치가 "_"인 경우 허리의 길이 계산이 끝난 것이기 때문에 반복문 종료
            else if(board[i][heartY].equals("_")){
                break;
            }
        }
        return hurry;
    }
    
    // 다리길이를 구하는 메서드
    static int[] calcLegsLength(String[][] board, int hurry, int[] legsLength,
                       int heartX, int heartY){
        // 왼쪽 다리 길이 계산
        for(int i = (heartX + hurry) + 1; i < board.length; i++){
            if(board[i][heartY - 1].equals("*")){ // 현재위치가 "*"인 경우 다리의 길이 계산
                legsLength[0]++;
            }
            // 현재위치가 "_"인 경우 다리의 길이 계산이 끝난 것이기 때문에 반복문 종료
            else if(board[i][heartY - 1].equals("_")){
                break;
            }
        }
        
        // 오른쪽 다리 길이 계산
        for(int i = (heartX + hurry) + 1; i < board.length; i++){
            if(board[i][heartY + 1].equals("*")){ // 현재위치가 "*"인 경우 다리의 길이 계산
                legsLength[1]++;
            }
            // 현재위치가 "_"인 경우 다리의 길이 계산이 끝난 것이기 때문에 반복문 종료
            else if(board[i][heartY + 1].equals("_")){
                break;
            }
        }
        return legsLength;
    }
}