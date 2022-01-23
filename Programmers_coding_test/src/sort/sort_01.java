package sort;

import java.util.Arrays;

/**
 *  ���α׷��ӽ� - �ڵ��׽�Ʈ���� - ���� - K��° ��
 *  
 * 	�迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.
	���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
	
	array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
	1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
	2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
	�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, commands�� ��� ���ҿ� ���� �ռ� 
	������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	����� ����)
	array					commands							return
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
	
		//Arrays.asList �� �迭�� String �迭 �ϰ�츸 ����� ������. int �迭������ �����ʴ� �� ����.
		//ArrayList<Integer> list = new ArrayList(Arrays.asList(array));
		
		answer = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			int int_A = commands[i][0]; //2
			int int_B = commands[i][1]; //5
			int int_C = commands[i][2]; //3
			
			//���� �迭�� �߶� (2��°�ڸ� ~ 5��°�ڸ�) ���ο� �迭 ����.
			int[] newArray = Arrays.copyOfRange(array, int_A-1, int_B);
			
			//���ο� �迭 �������� ����
			Arrays.sort(newArray);
			
			//���ο� �迭�� 3��° �ڸ� �� Ȯ��
			System.out.println("����="+newArray[int_C-1]);

			//����� �迭�� �����Է�
			answer[i]=newArray[int_C-1];	
		}
        return answer;
    }
}
