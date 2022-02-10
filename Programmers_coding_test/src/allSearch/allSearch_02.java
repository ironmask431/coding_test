package allSearch;

/*
코딩테스트연습 > 완전탐색 > 소수 찾기 (LV.2) (2022.02.10 완료)
 
문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 
소수를 몇 개 만들 수 있는지 알아내려 합니다.
각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 
만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

입출력 예
numbers	return
"17"	3
"011"	2

입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.
 */
public class allSearch_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String numbers = "172";
		solution(numbers);
	}
	
	public static int solution(String numbers) {
        int answer = 0;
        
        //현재 종이조각 에서 조합가능한 최대수 (2장이면 99, 3장이면 999)
        int max = (int) Math.pow(10,numbers.length())-1;
     
        //0 부터 최대수 까지 for문
        for(int i = 0; i <= max ; i++) {
            
            //now = 현재 체크하는 수
            String now = i+"";
            char[] now_arr = now.toCharArray();
            boolean pass = true;
            
            //현재 수를 자리수별로 쪼갠 숫자 검사.
            for(char c : now_arr) {   
                
                //numbers 에서 현재 숫자의 개수 
                long count_num = numbers.chars().filter(ch -> ch == c).count();
                
                //now에서 현재 숫자의 개수
                long count_now = now.chars().filter(ch -> ch == c).count();

                //현재숫자가 numbers에는 없는 숫자라면 false 처리
                if(count_num == 0) pass = false;
                
                //현재숫자의 numbers에서의 개수보다  now에서의 개수가 더 많으면 false처리
                if(count_num < count_now) pass = false; 
                
            } 
            if(pass) {  
                //i가 소수일경우 
                if(findSosu(i)) {
                	System.out.println("소수="+i);
                	answer++;
                }              
            }
        }     
        System.out.println("answer="+answer);
        return answer;
    }
	
	//소수 여부 return 메소드
    public static boolean findSosu(int num) {
        boolean flag = true;
        for(int i = 2; i < num ; i++) {
            if(num % i == 0) {
                flag = false;    
            }
        }
        //0,1은 false 처리
        if(num <= 1) {
            flag = false;
        }
        return flag;
    }
}

