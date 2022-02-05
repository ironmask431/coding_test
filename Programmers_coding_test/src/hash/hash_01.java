package hash;

import java.util.HashMap;
import java.util.Iterator;

/* 
코딩테스트연습 > 해시 > 완주하지 못한 선수 (LV.1) (2022.01.23 완료)

문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.

입출력 예
participant						completion					return
["leo", "kiki", "eden"]					["eden", "kiki"]				"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]			["stanko", "ana", "mislav"]			"mislav"

입출력 예 설명
예제 #1
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.	
 */
public class hash_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] p = {"mislav", "stanko", "mislav", "ana"};
		String[] c = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(p,c));		
	}
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";

//        ArrayList<String> pList = new ArrayList(Arrays.asList(participant));
//        ArrayList<String> cList = new ArrayList(Arrays.asList(completion));     
//      
        //참가자 명단의 하나의 이름의 인원수와  완료자 명단의 하나의 이름의 인원수 비교.  인원수가 다른 이름이 있다면 그 이름이 미완주자. 
        //아래방식으로는 효율성테스트에서 실패함. hashmap으로 대상을 찾는 것보다 속도가 느리나봄.
//    	for(String p : pList) {
//    		if(Collections.frequency(pList, p) != Collections.frequency(cList, p)) {
//    			answer = p;
//    			break;
//    		}
//    	}
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        //참여자 participant for문
        for(String p : participant) {
        	//key: p, value = map에서 p가 없다면1, 있으면 기존값 + 1 으로 put 실행
        	map.put(p, map.get(p) == null ? 1 : map.get(p) +1);
        }
        
        //완주자 completion for문
        for(String c : completion) {
        	//key : c, value = map에서 c를 찾은다음 기존값에서 -1 빼주기. 완주자는 0, 미완주자는 끝까지 1로 남아있게됨. 
        	map.put(c, map.get(c)-1);
        }
        
        Iterator<String> it = map.keySet().iterator();
        
        while(it.hasNext()) {
        	String key = it.next();
        	if(map.get(key) == 1) {
        		//value 가 1인 항목이 발견되면 종료.
        		answer = key;
        		break;
        	}
        }

        return answer;
    }
}
