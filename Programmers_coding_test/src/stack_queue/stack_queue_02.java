package stack_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
코딩테스트연습 > 스택/큐 > 프린터 (Lv.2) (2022.02.08 완료)

문제 설명
일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 
이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 
같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 
위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 
return 하도록 solution 함수를 작성해주세요.

제한사항
현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 
두 번째에 있으면 1로 표현합니다.

입출력 예
priorities		location	return
[2, 1, 3, 2]		2		1
[1, 1, 9, 1, 1, 1]	0		5

입출력 예 설명
예제 #1
문제에 나온 예와 같습니다.

예제 #2
6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 
중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
*/

public class stack_queue_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] priorities = {2, 1, 3, 2}; //현재 대기열의 중요도 
//		int location = 2; //내가 요청한 문서의 위치
		
		int[] priorities = {1, 1, 9, 1, 1, 1}; 
		int location = 0;
		
		solution(priorities,location);
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        //현재 대기문서의 중요도를 대기순으로 큐에 입력
        Queue<Integer> q = new LinkedList<Integer>();
        //현재 대기문서의 대기순번을 0~마지막번호 까지 입력
        Queue<Integer> q_index = new LinkedList<Integer>();
        //현재 대기문서들의 중요도를 높은순으로 정렬하는 우선순위 큐(max힙)에 입력
        PriorityQueue<Integer> h = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //재정렬된 대기열 순서 입력용 리스트
        List<Integer> list = new ArrayList();
        
        //priorities 대기열을 각 큐와 max힙에 입력
        for(int i=0; i<priorities.length; i++) {
        	q.add(priorities[i]);
        	q_index.add(i);
        	h.add(priorities[i]);
        }
        
        int cnt = 0;
        
        while(q.size() > 0) {
        	int q_one = q.poll(); //q에서 첫번째 값 꺼냄
        	int q_index_one = q_index.poll();//q_index 에서 첫번째 값 꺼냄
        	int h_one = h.peek(); //max힙의 첫번째 값 확인
        	
        	//큐의 첫번째요소가 중요도 가장높은 게 아니라면 q와 q_index에서 꺼낸 첫번째요소를 각 큐의 마지막으로 보냄.
        	if(q_one < h_one) {
        		q.add(q_one);
        		q_index.add(q_index_one);
        	}else {
        		//큐의 첫번째요소가 중요도 가장높은 거라면 max힙에서도 해당값 꺼냄.
        		h_one = h.poll();
        		list.add(q_index_one);
        	}
        	cnt++;
        }

        answer = list.indexOf(location)+1;
        System.out.println("answer="+answer);
        
        return answer;
    }
}
