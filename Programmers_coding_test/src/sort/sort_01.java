package sort;

import java.util.Arrays;

/**
 *  프로그래머스 - 코딩테스트연습 - 정렬 - K번째 수
 *  
 * 	배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
	예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
	
	array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
	1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
	2에서 나온 배열의 3번째 숫자는 5입니다.
	배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 
	설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	
	일출력 예시)
	array			commands				return
	[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 */

public class sort_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1, 5, 2, 6, 3, 7, 4};
		int[][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		solution(a,b);		
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
	
		//Arrays.asList 는 배열이 String 배열 일경우만 제대로 동작함. int 배열에서는 되지않는 것 같음.
		//ArrayList<Integer> list = new ArrayList(Arrays.asList(array));
		
		answer = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			int int_A = commands[i][0]; //2
			int int_B = commands[i][1]; //5
			int int_C = commands[i][2]; //3
			
			//기존 배열을 잘라서 (2번째자리 ~ 5번째자리) 새로운 배열 만듬.
			int[] newArray = Arrays.copyOfRange(array, int_A-1, int_B);
			
			//새로운 배열 오름차순 정렬
			Arrays.sort(newArray);
			
			//새로운 배열의 3번째 자리 수 확인
			System.out.println("정답="+newArray[int_C-1]);

			//정답용 배열에 정답입력
			answer[i]=newArray[int_C-1];	
		}
        return answer;
    }
}
