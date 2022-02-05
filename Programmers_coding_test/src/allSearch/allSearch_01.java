package allSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
코딩테스트연습 > 완전탐색 > 모의고사 (LV.1) (2022.01.24 완료)
 
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 
사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

입출력 예
answers		return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]

입출력 예 설명

입출력 예 #1
수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2
모든 사람이 2문제씩을 맞췄습니다.
 */
public class allSearch_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] answers = {1,2,3,4,5};
//		int[] answers = {1,3,2,4,2};

		solution(answers);
	}
	
	public static int[] solution(int[] answers) {
        int[] answer = {};
        
        //참가자 1,2,3번의 문제찍는 반복패턴 설정
        int[] man_1 = {1, 2, 3, 4, 5}; //패턴길이 5  
        int[] man_2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 패턴길이 7 
        int[] man_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //패턴길이 9

        //참가자 1,2,3의 정답맞춘 횟수
        int man_1_cnt = 0;
        int man_2_cnt = 0;
        int man_3_cnt = 0;
        
        //전체 문제정답 for문
        for(int i = 0 ; i < answers.length; i++) {                 
            
            //(현재문제 정답) 과  (현재 문제순번 % 문제찍는패턴의 길이 = 현재찍은 정답)을 비교. 일치하면 cnt++; 
            if(answers[i] == man_1[i%man_1.length]) {
                man_1_cnt++;
            }            
            if(answers[i] == man_2[i%man_2.length]) {
                man_2_cnt++;
            }      
            if(answers[i] == man_3[i%man_3.length]) {
                man_3_cnt++;
            }    
        }      
   
        //각 참가자의 정답횟수를 test에 입력 
        int[] test = {man_1_cnt, man_2_cnt, man_3_cnt};
        
        //오름차순 정리 
        Arrays.sort(test);
 
        List<Integer> list = new ArrayList<Integer>();
   
        //test 리스트의 마지막 수(최대값)과 각 참가자의 정답횟수가 일치하면 최대정답자. 최대정답자를 list에 add
        if(test[test.length-1] == man_1_cnt) {
            list.add(1);
        }
        if(test[test.length-1] == man_2_cnt) {
            list.add(2); 
        }
        if(test[test.length-1] == man_3_cnt) {
            list.add(3);
        }
        
        //list를 answer[] 배열로 변환     
        answer = new int[list.size()];
        
        for(int i=0 ; i<list.size(); i++) {
            answer[i] = list.get(i);
            //System.out.println("정답:"+answer[i]);
        }
        
        return answer;
    }
}

