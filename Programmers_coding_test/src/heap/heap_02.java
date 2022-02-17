package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
코딩테스트연습 > 힙(heap) > 이중우선순위큐(Lv.3) (2022.02.17 완료)

문제 설명
이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

명령어    수신 탑(높이)
I 숫자   큐에 주어진 숫자를 삽입합니다.
D 1	 큐에서 최댓값을 삭제합니다.
D -1	 큐에서 최솟값을 삭제합니다.
이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 
모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 
return 하도록 solution 함수를 구현해주세요.

제한사항
operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
operations의 원소는 큐가 수행할 연산을 나타냅니다.
원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 
최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.

입출력 예
operations			return
["I 16","D 1"]			[0,0]
["I 7","I 5","I -5","D -1"]	[7,5]

입출력 예 설명
16을 삽입 후 최댓값을 삭제합니다. 비어있으므로 [0,0]을 반환합니다.
7,5,-5를 삽입 후 최솟값을 삭제합니다. 최대값 7, 최소값 5를 반환합니다.

*/

public class heap_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; 
		// 기대값 	[0, 0]		
//		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; 
		// 기대값 [333, -45]		
		solution(operations);	
	}
	
	public static int[] solution(String[] operations) {
        
		int[] answer = {};

		//오름차순 우선순위 큐 (최소값이 첫번째)
		PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();
		//내림차순 우선순위 큐 (최대값이 첫번째)
		PriorityQueue<Integer> RQ = new PriorityQueue<Integer>(Collections.reverseOrder());

		for(int i = 0; i < operations.length; i++) {
			String[] arr = operations[i].split(" ");

			//명령어 : I=입력 D=최대값or최소값 빼기
			String order = arr[0];
			//수치
			int num  = Integer.parseInt(arr[1]);

			System.out.println(order+" "+num);

			if(order.equals("I")) {
				//입력
				PQ.add(num);
				RQ.add(num);
			}else if(order.equals("D") && num == 1) {
				//최댓값 삭제
				if(RQ.size() > 0) {
					//RQ의 첫번째요소 (최대값)을 꺼내고, PQ에서도 삭제해준다.
					int max = RQ.poll();
					PQ.remove(max);
				}
			}else if(order.equals("D") && num == -1) {
				//최소값 삭제
				if(PQ.size() > 0) {
					//PQ의 첫번째요소 (최소값)을 꺼내고, RQ에서도 삭제해준다.
					int min = PQ.poll();
					RQ.remove(min);
				}
			} 
		}

		answer = new int[2];
		answer[0] = RQ.peek() == null ? 0 : RQ.peek(); //최대값
		answer[1] = PQ.peek() == null ? 0 : PQ.peek(); //최소값

		System.out.println("최대="+answer[0]);
		System.out.println("최소="+answer[1]);

		return answer;
	    }
}
