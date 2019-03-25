import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 전역변수 map의 형을 int -> boolean으로 변경하니 메모리초과 이 해결.
 * 인접배열 -> 인접행렬로 변경
 * dfs함수가 관건.
 * 
 * @author quadcore
 *
 */
public class Main{
	public static ArrayList<Integer>[] newmap;
	public static int res[] = new int[10001];
	public static boolean [] list;
    public static void main(String[] args) throws IOException {
    	LinkedList<Integer> output = new LinkedList<>();
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int max = Integer.parseInt(st.nextToken());
    	int num = Integer.parseInt(st.nextToken());
    	newmap = new ArrayList[max+1];
    	for (int i = 1; i <= max; i++) {
			newmap[i] = new ArrayList<>();
		}
    	for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			newmap[x].add(y);
		}
    	//1번 컴퓨터부터 dfs
    	for (int i = 1; i <=max; i++) {
			list = new boolean[max+1];
			dfs(i);
		}
    	//최대값을 구하
    	int tmp = 0;
    	for (int i = 1; i <= max; i++) {
			if (tmp < res[i]) {
				tmp = res[i];
			}
		}
    	//1부터 돌면서 최대값과 같으면 출
    	for (int i = 1; i <= max; i++) {
			if (res[i] == tmp) {
				System.out.print(i+" ");
			}
		}
/**/
    }
    
    public static void dfs(int input) {
    	list[input] = true;
    	for (int x : newmap[input]) {
    		//이미 한번 방문한 것은 걸
			if (!list[x]) {
				dfs(x);
				res[x]++;
			}
		}
    }
}