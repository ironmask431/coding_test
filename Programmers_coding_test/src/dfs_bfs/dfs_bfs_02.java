package dfs_bfs;

/*
코딩테스트연습 > 깊이/너비 우선탐색(DFS/BFS) > 네트워크(Lv.3) (2022.02.16 완료)

문제 설명
네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 
컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 
있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 
컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 
네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

제한사항
컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
computer[i][i]는 항상 1입니다.

입출력 예
n	computers				return
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1

*/
public class dfs_bfs_02 {
	//방문노드 기록용 
	static int[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
		//인접 행렬 형태의 그래프
//		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; // answer=2
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}; // 1
//		int[][] computers = {{1,1,0,0}, {1,1,0,0}, {0,0,1,1},{0,0,1,1}}; // 2
		int[][] computers = {{1,1,0,0}, {0,1,0,1}, {0,0,1,0},{0,1,1,1}}; // 1
		
		solution(n, computers);
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new int[n];      
		for(int i=0; i<computers.length; i++) {
			//방문하지 않은 노드일경우
			if(visited[i] != 1) {
				System.out.println("new 탐색시작="+i);
				//네트워크 수++
				answer++;
				dfs(computers,i);
			}	
		}
		System.out.println("answer="+answer);
		return answer;
	    }
	
	public static void dfs(int[][] computers, int start) {
		//start지점 방문 처리
		visited[start] = 1;
		System.out.println("방문노드="+start);
		for(int i=0; i<computers[start].length; i++) {
			// 현재노드의 i번째 요소가 1:연결 상태이고, i노드가 방문하지 않은 노드일경우 탐색시작
			if(computers[start][i] == 1 && visited[i] != 1) {
				dfs(computers,i);
			}
		}	
	}
}
