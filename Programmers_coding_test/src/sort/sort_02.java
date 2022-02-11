package sort;

import java.util.Arrays;

/**
코딩테스트연습 > 정렬 > 가장 큰 수(Lv.2) (2022.02.09 완료)
** (다른 풀이 참고하여 코드작성) **

문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 
만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 
장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

입출력 예
numbers			return
[6, 10, 2]		"6210"
[3, 30, 34, 5, 9]	"9534330"

 */

public class sort_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = {3, 30, 34, 5, 9};
		
		solution(numbers);		
	}
	
	public static String solution(int[] numbers) {
        String answer = "";
        
        String[] text_arr = new String[numbers.length];
            
        //numbers 배열을 String 타입배열 text_arr 에 옮겨담음 
        for(int i = 0; i < numbers.length ; i++) { 
            text_arr[i] = numbers[i]+"";
        }
        
        //compareTo를 이용해서 정렬
        Arrays.sort(text_arr,(s1,s2) -> (s2+s1).compareTo(s1+s2));

        //text_arr를 answer에 입력 
        for(String i : text_arr) { 
            answer+=i;
         }

        //text_arr 첫번째 요소가 0일경우 (0,0,0,...) answer는 0으로 처리
        if(text_arr[0].equals("0")) {
            answer = "0";
        }
        System.out.println("answer="+answer);
        return answer;
    }
}
