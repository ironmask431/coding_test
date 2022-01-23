package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/*
	���α׷��ӽ� - �ڵ��׽�Ʈ���� - �ؽ� - �������� ���� ����
	
	������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
	�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, 
	�������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���ѻ���
	������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
	completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
	�������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
	������ �߿��� ���������� ���� �� �ֽ��ϴ�.
 */
/*
 * ù��° �ڵ� : ��Ȯ�� �׽�Ʈ ��� / ȿ���� �׽�Ʈ ����
 * �ι�° �ڵ� : hashmap Ȱ�� - ��ü��� 
 * list ���� ��Ҹ� ã�� ����� hashmap���� key�� ã�� ��ĺ��� ȿ������ ����������. 
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

        //ù��° �ڵ�
//        ArrayList<String> pList = new ArrayList(Arrays.asList(participant));
//        ArrayList<String> cList = new ArrayList(Arrays.asList(completion));
//        
//        //������ ����Ʈ for�� ���鼭 �ش� �̸����� �����ڸ�ܿ����� ������ ������ ��ܿ����� ���� ��. 
//        //������ ���� �ٸ��� �ִٸ� �׻���� �̿�����.
//    	for(String p : pList) {
//    		if(Collections.frequency(pList, p) != Collections.frequency(cList, p)) {
//    			answer = p;
//    			break;
//    		}
//    	}
        
        //�ι�° �ڵ� : hashmap Ȱ��
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(String p : participant) {
        	//key: p, value = map���� p�� ���ٸ�1, ������ ������ + 1 ���� put ����
        	//key : �����̸�, value : �� �̸��� �ο��� �� ��.
        	map.put(p, map.get(p) == null ? 1 : map.get(p) +1);
        }
        
        for(String c : completion) {
        	//key : c, value = map���� c�� ã������ ���������� -1 ���ֱ�. 
        	//��ü �� �����ϸ� �����ڴ� 0, �̿����ڴ� ������ 1�� �����ְԵ�. 
        	map.put(c, map.get(c)-1);
        }
        
        Iterator<String> it = map.keySet().iterator();
        
        while(it.hasNext()) {
        	String key = it.next();
        	if(map.get(key) == 1) {
        		//value �� 1�� �׸�(�̿�����)�� �߰ߵǸ� ����.
        		answer = key;
        		break;
        	}
        }

        return answer;
    }
}
