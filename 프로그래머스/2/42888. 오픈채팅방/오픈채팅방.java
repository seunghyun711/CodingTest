import java.util.*;

/*
1. Enter와 Change 명령어에 대한 작업을 수행
2. Enter와 Leave에 대한 메시지 생성
3. 결과 리턴
*/
class Solution {
    static String[] answer;
    static List<String> messages = new ArrayList<>();
    static Map<String, String> map = new HashMap<>();
    public String[] solution(String[] record) {
        StringTokenizer st;

        // 1. Enter와 Change 명령어에 대한 작업을 수행
        for(int i = 0; i < record.length; i++){
            st = new StringTokenizer(record[i]);
            String command = st.nextToken(); // 명령어
            String uid = st.nextToken(); // 유저 아이디
            String nickname = ""; // 닉네임
            
            if(command.equals("Enter")){ // 명령어가 Enter인 경우 map에 uid와 닉네임 저장
                nickname = st.nextToken(); // 닉네임
                map.put(uid, nickname);
            }else if(command.equals("Change")){ // 명령어가 Change인 경우 map에 변경된 닉네임 저장
                nickname = st.nextToken(); // 닉네임
                map.put(uid, nickname);
            }
        }
        
        // 2. Enter와 Leave에 대한 메시지 생성
        for(int i = 0; i < record.length; i++){
            st = new StringTokenizer(record[i]);
            String command = st.nextToken();
            String uid = st.nextToken();
            String nickname = "";
            
            if(command.equals("Enter")){
                nickname = map.get(uid); // 입력한 유저의 닉네임
                messages.add(nickname + "님이 들어왔습니다.");
            }else if(command.equals("Leave")){
                nickname = map.get(uid); // 입력한 유저의 닉네임
                messages.add(nickname + "님이 나갔습니다.");
            }
        }
        
        // 3. 결과 리턴
        answer = new String[messages.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = messages.get(i);
        }
        return answer;
    }
}