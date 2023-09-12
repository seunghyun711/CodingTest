/*
1. 입력으로 시, 분, 추가시간 입력
2. 입력한 추가시간을 시간과 분에 적용
3. 분 + 추가시간이 60이상이면 시간 += 1, 분 -= 60
4. 시간이 24 이상이면 시간 -= 24
*/
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 입력으로 시, 분, 추가시간 입력
        int hour = sc.nextInt(); // 시간 입력
        int minutes = sc.nextInt(); // 분 입력
        int addMinutes = sc.nextInt(); // 추가할 시간 입력
        
        //2. 입력한 추가시간을 시간과 분에 적용
        hour += addMinutes / 60;
        minutes += addMinutes % 60;
        
        //3. 분 + 추가시간이 60이상이면 시간 += 1, 분 -= 60
        if(minutes >= 60){
            hour += 1;
            minutes -= 60;
        }
        
        // 4. 시간이 24 이상이면 시간 -= 24
        if(hour >= 24){
            hour -= 24;
        }
        
       
        System.out.println(hour + " " + minutes);
    }
}
