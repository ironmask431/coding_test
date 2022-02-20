package sort;

import java.util.Arrays;
import java.util.Comparator;

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

public class sort_2_retry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = {3, 30, 34, 5, 9};
		//9 5 34 3 30
		
		solution(numbers);		
	}
	
	public static String solution(int[] numbers) {
        String answer = "";

        //String 배열로 변환 
        String [] stArr = new String[numbers.length]; 
        for(int i=0; i<numbers.length; i++ ) {
        	stArr[i] = String.valueOf(numbers[i]);
        }
        
        //Comparator 사용하여 별도 정렬기준으로 정렬 
        //Comparator 가 -1 리턴시 o1,o2 순서유지
        //Comparator 가 1 리턴시 o1,o2 순서변경 
        Arrays.sort(stArr,new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		int result = 0;
        		int num1 = Integer.parseInt(o1+o2); //num1 이 더 크면 o1,o2는 원하는순서 
        		int num2 = Integer.parseInt(o2+o1); //num2 이 더 크면 o1,o2는 순서를 바꿔줘야함.  
        		
        		if(num1 > num2) { //원하는 순서.
        			result = -1;
        		}else if(num1 < num2) { //반대되는 순서	
        			result = 1;
        		}
        		return result;
        	}
        });
        
        StringBuffer sb = new StringBuffer();
        for(String s : stArr) {
        	System.out.println(s);
        	sb.append(s);
        }
        answer = sb.toString();

        //배열에 0만 있었다면 answer = "0" 으로.
        if(stArr[0].equals("0")) {
        	answer = "0";
        } 
        System.out.println("answer="+answer);
        
        return answer;
    }
}
