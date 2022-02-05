package heap;

import java.util.PriorityQueue;

/*
코딩테스트연습 > 힙(heap) > 더맵게(Lv.2) (2022.02.04 완료)

문제 설명
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 
만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 
K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.

입출력 예
scoville		K	return
[1, 2, 3, 9, 10, 12]	7	2

입출력 예 설명
스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
가진 음식의 스코빌 지수 = [13, 9, 10, 12]

모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
*/

public class heap_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		
		solution(scoville, k);	
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        //min heap 자료구조를 가지는 PriorityQueue 선언
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        //scoville 배열을 minHeap 에 입력
        for(int i : scoville) {
        	minHeap.add(i);
        }
        
        //minHeap의 첫번째 요소가 목표스코빌 이상이 될때까지 반복
        while(minHeap.peek() < K) {
        	//첫번째 값 꺼냄.
        	int one = minHeap.poll();
        	
        	//두번째 값이 null 일 경우는 목표스코빌 도달 실패 이므로 break;
        	if(minHeap.peek() == null) {
        		answer = -1;
        		break;
        	}
        	
        	// 첫번째 꺼낸값 + 두번째꺼낸값 * 2 을 합친값을 minHeap에 추가
        	int newNum = one + (minHeap.poll() * 2);
        	minHeap.add(newNum);
        	
        	//정답횟수 ++ 
        	answer++;
        } 
        
        System.out.println(answer);
        
        return answer;
    }
}
