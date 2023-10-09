/*
1. Map을 통해 등급과 등급의 점수 매칭
2. 과목명, 학점, 등급 순서로 입력
3. 입력받은 문자열을 공백을 기준으로 과목명, 학점, 등급을 분리
4. 등급이 P인 경우는 산출에서 제외
5. 전공과목별 (학점 × 과목평점) 합 / 학점의 총합을 통해 전공평점 산출
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. Map을 통해 등급과 등급의 점수 매칭(ex: A+, 4.5)
        HashMap<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        map.put("P", -1.1); // P를 과목 산출에서 제외하기 위해 임의 값을 value로 지정
        
        String[] s = new String[20];
        double total = 0; // (학점 × 과목평점) 합
        double sum = 0; // 학점의 총합
        
        // 2. 과목명, 학점, 등급 순서로 입력
        for(int i = 0; i < 20; i++){
            s[i] = br.readLine(); 
            
            // 3. 입력받은 문자열을 공백을 기준으로 과목명, 학점, 등급을 분리
            StringTokenizer st = new StringTokenizer(s[i], " ");
            String subject = st.nextToken(); // 과목명
            double score = Double.parseDouble(st.nextToken()); // 학점
            String grade = st.nextToken(); // 등급
            
            // 4. 등급이 P인 경우는 산출에서 제외
            if(map.get(grade) == -1.1){ // 등급이 P인 경우
                continue;
            }else{
                total += score  * map.get(grade); // 학점 * 과목평점의 합
                sum += score; // 학점의 총합
            }
            
        }
        // 5. 전공과목별 (학점 × 과목평점) 합 / 학점의 총합을 통해 전공평점 산출
        double avg = total / sum; // 평균
        System.out.printf("%.6f\n", avg);
        
    }
   
}