package dfs_bfs;

/*
코딩테스트연습 > 깊이/너비 우선탐색(DFS/BFS) > 타켓넘버(Lv.2) (2022.02.05 완료)

문제 설명
n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 
타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.

입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2

입출력 예 설명
입출력 예 #1
문제 예시와 같습니다.

입출력 예 #2
+4+1-2+1 = 4
+4-1+2-1 = 4
총 2가지 방법이 있으므로, 2를 return 합니다.
*/
public class dfs_bfs_01 {

	static int answer2 = 0; //answer에 입력할 static 변수
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers = {1,2,3};
    	int target = 0;
		
		solution(numbers, target);
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;  

        //numbers = {1,2,3} 일 경우 
        //1+2+3 = 6
        //1+2-3 = 0
        //1-2+3 = 2
        //1-2-3 = -4 
        //-1+2+3 = 4
        //-1+2-3 = -2
        //-1-2+3 = 0
        //-1-2-3 = -6
        // 8가지(2^배열의길이) 경우의 수가 나온다. 8가지 경우의 수를 모두 계산한후 target과 비교
        
        dfs(numbers, target, numbers[0],0); //배열의 첫번째 값부터 시작
        dfs(numbers, target, numbers[0]*-1,0);//배열의 첫번째 값*-1 부터 시작
        
        answer = answer2;
        
        System.out.println("answer="+answer);
        
        return answer;
    }
	
	public static void dfs(int[] numbers, int target, int now, int index) {
		index++;
		System.out.println("----index="+index);
		//현재값(now) 과 numbers배열의 다음값을 +, - 로 각각 계산하는 메소드
		//현재값 + 다음값
		int cal_1 = now + numbers[index];
		//현재값 - 다음값
		int cal_2 = now - numbers[index];
		
		System.out.println("cal1="+cal_1);
		System.out.println("cal2="+cal_2);
		
		//index값이 numbers의 마지막까지 가면 재귀함수 종료 
		if(numbers.length-1 == index) {
			//cal_1, cal_2값이 각각 target과 일치할때마다 answer2의 값 ++ 
			if(cal_1 == target) {
				answer2++;
			}
			if(cal_2 == target) {
				answer2++;
			}
			System.out.println("종료");
		}else {
			//다음 배열값이 있을 경우 재귀함수호출
			dfs(numbers, target, cal_1, index);
			dfs(numbers, target, cal_2, index);
		}
	}
}
