package greedy;

import java.util.ArrayList;
import java.util.List;

/* 
코딩테스트연습 > 탐욕법(Greedy) > 큰 수 만들기 (LV.2) 2022.02.22 완료
	
문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 
를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 
주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 
문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.

입출력 예
number		k	return
"1924"		2	"94"
"1231234"	3	"3234"
"4177252841"	4	"775841"
	
 */
public class greedy_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String number = "4177252841";
//		int k = 4;
		
//		String number = "4177252841";
		String number = "9999999999";
//		String number = "9876543211";
		int k = 9;
		
		//스택 4, 1, 7, 
		// 1뽑고 4뽑고 7push
		// 7,7,2 push 
		// 
		solution(number, k);
	}

	public static String solution(String number, int k) {
        String answer = "";
        
        int afterSize = number.length()-k;
        
        //문자열 배열로
        String [] arr = number.split("");
        List<Integer> list = new ArrayList<Integer>();
        int max = 0;
        for(String s : arr) {
        	int i = Integer.parseInt(s);
        	if(max < i) {
        		max = i;
        	}
        	list.add(i);
        }
//        System.out.println("max="+max);
        int index = 0;
        
        while(k > 0 && index < list.size()) {
        	int a = list.get(index);
//        	System.out.println("a="+a);
        	if(a < max) {
        		for(int i=index+1; i<=index+k; i++) {
            		if(list.size()-1 >= index+k) {
            			int b = list.get(i);
//                		System.out.println("b="+b);
                		if(a < b) {
                			list.remove(index);
//                			System.out.println("삭제="+a);
                			k--;
                			index--;
                			break;
                		}
            		}	
            	}//for문 종료
        	}
        	index++;
        }

        StringBuffer sb = new StringBuffer();
        for(int n : list) {
        	sb.append(n);
        }
        answer = sb.toString();
   
        if(answer.length()> afterSize) {
        	answer = answer.substring(0, afterSize);
        }
        System.out.println(answer);
        
        return answer;
    }

}
