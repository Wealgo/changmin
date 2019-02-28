import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class Main{
    public static int n;
    public static int[][] oldMap;
    public static int[][] newMap;
    public static int[] visited;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int size = sc.nextInt();

    	oldMap = new int [size][size];
    	newMap = new int [size][size];
    	visited = new int [size];
    	for (int i = 0; i < oldMap.length; i++) {
			for (int j = 0; j < oldMap.length; j++) {
				oldMap[i][j] = sc.nextInt();
			}
		}	
    	for (int i = 0; i < oldMap.length; i++) {
			dfs(i);
			/**
			 * 여기 2중 포문이 핵심.
			 * 즉, newMap에서 받아오는것보다는,
			 * 전역변수 visited배열을 활용해서 처리하자.
			 */
			for (int j = 0; j < newMap.length; j++) {
				newMap[i][j] = visited[j];
			}
			//
			visited = new int[size];
		}
    	for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap.length; j++) {
				System.out.print(newMap[i][j] + " ");
			}
			System.out.println();
		}
    }
    public static void dfs(int location) {
    	for (int i = 0; i < oldMap.length; i++) {
			if (oldMap[location][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				/**
				 * 내가 했던 실수.
				 * 여기서 newMap이라는 전역변수를 사용해서 바로 1을 넣어버리는 짓은 하지말자
				 * ex) newMap[location][i] = 1;
				 * location 변수가 들어올때마다 바뀌므로 출력해보면 인풋과 똑같은 값들을 아웃풋으로 보내게 된다.
				 */
				dfs(i);
			}
		}
    }
}