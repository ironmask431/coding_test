package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/*
	프로그래머스 - 코딩테스트연습 - 해시 - 완주하지 못한 선수
	
	수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
	마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
	완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	
	제한사항
	마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
	completion의 길이는 participant의 길이보다 1 작습니다.
	참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
	참가자 중에는 동명이인이 있을 수 있습니다.
 */
/*
 * 첫번째 코드 : 정확성 테스트 통과 / 효율성 테스트 실패
 * 두번째 코드 : hashmap 활용 - 전체통과 
 * list 에서 요소를 찾는 방식이 hashmap에서 key를 찾는 방식보다 효율성이 안좋은가봄. 
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

        //첫번째 코드
//        ArrayList<String> pList = new ArrayList(Arrays.asList(participant));
//        ArrayList<String> cList = new ArrayList(Arrays.asList(completion));
//        
//        //참가자 리스트 for문 돌면서 해당 이름의의 참가자명단에서의 개수와 완주자 명단에서의 개수 비교. 
//        //개수가 서로 다른게 있다면 그사람이 미완주자.
//    	for(String p : pList) {
//    		if(Collections.frequency(pList, p) != Collections.frequency(cList, p)) {
//    			answer = p;
//    			break;
//    		}
//    	}
        
        //두번째 코드 : hashmap 활용
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(String p : participant) {
        	//key: p, value = map에서 p가 없다면1, 있으면 기존값 + 1 으로 put 실행
        	//key : 선수이름, value : 그 이름의 인원수 가 됨.
        	map.put(p, map.get(p) == null ? 1 : map.get(p) +1);
        }
        
        for(String c : completion) {
        	//key : c, value = map에서 c를 찾은다음 기존값에서 -1 빼주기. 
        	//전체 다 실행하면 완주자는 0, 미완주자는 끝까지 1로 남아있게됨. 
        	map.put(c, map.get(c)-1);
        }
        
        Iterator<String> it = map.keySet().iterator();
        
        while(it.hasNext()) {
        	String key = it.next();
        	if(map.get(key) == 1) {
        		//value 가 1인 항목(미완주자)이 발견되면 종료.
        		answer = key;
        		break;
        	}
        }

        return answer;
    }
}
