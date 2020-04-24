import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 와 이거 어케풀었누?
 */
public class Main {
	public static int[][] soonRam = {
			{0,1,2,3,4,5}, 
			{2,2,3,4,5,9}, 
			{4,3,4,5,9,10}, 
			{6,4,5,9,10,11},
			{8,5,9,10,11,12},
			{10,6,7,8,20,29},
			{13,7,8,20,29,30},
		    {16,8,20,29,30,31}, 
			{19,20,29,30,31,32}, 
			{12,10,11,12,13,14}, 
			{14,11,12,13,14,15}, 
			{16,12,13,14,15,16}, 
			{18,13,14,15,16,17}, 
			{20,18,19,20,29,30}, 
			{22,15,16,17,24,25}, 
			{24,16,17,24,25,26}, 
			{26,17,24,25,26,27}, 
			{28,24,25,26,27,28}, 
			{22,19,20,29,30,31}, 
			{24,20,29,30,31,32}, 
			{25,29,30,31,32,32}, 
			{26,20,29,30,31,32}, 
			{27,21,20,29,30,31}, 
			{28,22,21,20,29,30}, 
			{30,23,22,21,20,29}, 
			{32,26,27,28,31,32}, 
			{34,27,28,31,32,32}, 
			{36,28,31,32,32,32}, 
			{38,31,32,32,32,32}, 
			{30,30,31,32,32,32}, 
			{35,31,32,32,32,32}, 
			{40,32,32,32,32,32}, 
			{0,32,32,32,32,32} 
};
	public static int[] DiceResult = new int[10];
	public static int answer = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < 10; i++) {
			DiceResult[i] = Integer.parseInt(st.nextToken());
		}
    	visited = new boolean[4];
    	LinkedList<Integer> list = new LinkedList<>();
    	back(list);
//    	for (int i = 0; i < 10; i++) {
//			list.add(1);
//		}
//    	visited = new boolean[33];
//    	wan(list);
    	System.out.println(answer);
    }
    public static boolean[] visited;
    public static int cnt = 0;
    public static void back(LinkedList<Integer> list) {
    	if (list.size() > 10) {
    		visited = new boolean[33];
    		wan(list);
    		cnt++;
    		return;
    	}
    	for (int i = 1; i <= 4; i++) {
			list.add(i);
			back(list);
			list.removeLast();
		}
    }
    public static void wan(LinkedList<Integer> horseSoon) {
    	int output = 0;
    	int[] horseWhich = {0,0,0,0,0};
    	for (int i = 0; i < 10; i++) {
    		//이동 할 horse
			int horse = horseWhich[horseSoon.get(i)];
			//이동 할 거리.
			int move = DiceResult[i];
			//이동 한 horse의 위치.
			int nh = soonRam[horse][move];
			if (visited[nh] && nh != 32 && nh != 0) return;
			int v = soonRam[nh][0];
			horseWhich[horseSoon.get(i)] = nh;
			visited[nh] = true;
			visited[horse] = false;
			output = output + v;
		}
    	if (answer < output) {
			answer = output;
		}
    }
}

