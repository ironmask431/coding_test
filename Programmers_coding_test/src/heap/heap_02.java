package heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/*
코딩테스트연습 > 힙(heap) > 더맵게(Lv.2) (2022.02.04 완료)

*/

public class heap_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; // 기대값 	[0, 0]
		
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; // [333, -45]
		
		solution(operations);	
	}
	
	public static int[] solution(String[] operations) {
        
		int[] answer = {};

		//큐 의 .remove(); 메소드를 사용하지 않고 구현
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		//오름차순 우선순위 큐 (최소값이 첫번째)
		PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();
        //내림차순 우선순위 큐 (최대값이 첫번째)
        PriorityQueue<Integer> RQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
        	String[] arr = operations[i].split(" ");
        	
        	String order = arr[0];
        	int num  = Integer.parseInt(arr[1]);
        	
        	System.out.println(order+" "+num);
        	
        	if(order.equals("I")) {
        		map.put(num, map.get(num) == null ? 1 : map.get(num)+1);
        		PQ.add(num);
        		RQ.add(num);
        	}else if(order.equals("D") && num == 1) {
        		//최댓값 삭제
        		if(RQ.peek() != null) {

        			int max = RQ.poll();
        			if(map.get(max) > 0) {
            			map.put(max, map.get(max)-1);
            		}else {
            			i--;
            		}
        		}
        	}else if(order.equals("D") && num == -1) {
        		//최소값 삭제
        		if(PQ.peek() != null) {
        			int min = PQ.poll();
        			System.out.println("min여기="+min);
            		if(map.get(min) > 0) {
            			map.put(min, map.get(min)-1);
            		}else {
            			i--;
            		}
        		}
        	} 
        	
        	System.out.println("PQ="+PQ.toString());
        	System.out.println("RQ="+RQ.toString());
        	System.out.println("map="+map.toString());
        	System.out.println("------------");
        }
        
        PQ.clear();
        RQ.clear();
        
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()) {
        	int key = it.next();
        	System.out.println("key="+key+"/value="+map.get(key));
        	if(map.get(key) > 0) {
        		PQ.add(key);
        		RQ.add(key);
        	}
        }
        System.out.println("최대값="+RQ.peek());
        System.out.println("최소값="+PQ.peek());
       
        answer = new int[2];
        answer[0] = RQ.peek() == null ? 0 : RQ.peek();
        answer[1] = PQ.peek() == null ? 0 : PQ.peek();

        return answer;
    }
}
