package hash;

import java.util.HashMap;
import java.util.Map;

/* 
코딩테스트연습 > 해시 > 위장 (LV.2) (2022.02.11 완료) 
** (다른 풀이 참고하여 코드작성) **

스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 
입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

종류	이름
얼굴	동그란 안경, 검정 선글라스
상의	파란색 티셔츠
하의	청바지
겉옷	긴 코트
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 
return 하도록 solution 함수를 작성해주세요.

제한사항
clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
같은 이름을 가진 의상은 존재하지 않습니다.
clothes의 모든 원소는 문자열로 이루어져 있습니다.
모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
스파이는 하루에 최소 한 개의 의상은 입습니다.

입출력 예
clothes												return
[["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]	5
[["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]			3

입출력 예 설명
예제 #1
headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasse
s이므로 아래와 같이 5개의 조합이 가능합니다.
1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses

예제 #2
face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.
1. crow_mask
2. blue_sunglasses
3. smoky_makeup
*/

public class hash_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		solution(clothes);
	}
	
	public static int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String,Integer> map = new HashMap();
        
        //map에  key:옷종류 , value: 해당옷종류의 개수 입력
        //ex) {eyewear=1, headgear=2}
        for(String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1],0)+1);  
        }   
//        System.out.println(map.toString());
        
        //headgear : 2가지 >  미착용,1,2 (3가지 경우의수) 
        //eyewear : 1가지  > 미착용,1 (2가지경우의 수 )
        //가능한조합 : 3 * 2 = 6 에서 모두 미착용 1케이스만 빼줌.  
        
        for(String key : map.keySet()) {
            answer*=map.get(key)+1;
        }  
        answer -= 1;
        System.out.println("answer="+answer);
        
        return answer;
    }

}
