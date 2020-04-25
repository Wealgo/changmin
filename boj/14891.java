import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 문제 지문 뭐같네;;
 */
public class Main {
	public static LinkedList<Integer>[] topnis = new LinkedList[5];
	public static int[] DiceResult = new int[10];
	public static int answer = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	for (int i = 0; i < 4; i++) {
    		String tmp = br.readLine();
    		topnis[i] = new LinkedList<>();
    		for (int j = 0; j < 8; j++) {
				topnis[i].add((int)tmp.charAt(j)-48);
			}
		}
    	
    	int n = Integer.parseInt(br.readLine());
    	for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int gijon = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			boolean dir = false;
			if (t == 1) {
				dir = true;
			}

			rightSide(gijon, !dir);
			leftSide(gijon, !dir);
			if (dir) {
				right(gijon);
			} else {
				left(gijon);
			}
		}
    	
    	if (topnis[0].get(0).equals(1)) answer= answer+1;
    	if (topnis[1].get(0).equals(1)) answer= answer+2;
    	if (topnis[2].get(0).equals(1)) answer= answer+4;
    	if (topnis[3].get(0).equals(1)) answer= answer+8;
    	System.out.println(answer);
    }
    public static void rightSide(int idx, boolean dir) {
    	boolean[] visited = new boolean[4];
    	for (int i = idx; i < 3; i++) {
			if (topnis[i].get(2).equals(topnis[i+1].get(6))) break;
			visited[i+1] = true;
		}
    	for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) continue;
			if (dir) {
				right(i);
				dir = false;
			} else {
				left(i);
				dir = true;
			}
		}
    }
    public static void leftSide(int idx, boolean dir) {
    	boolean[] visited = new boolean[4];
    	for (int i = idx; i > 0; i--) {
			if (topnis[i-1].get(2).equals(topnis[i].get(6))) break;
			visited[i-1] = true;
    	}
    	for (int i = idx-1; i >= 0; i--) {
			if (!visited[i]) continue;
			if (dir) {
				right(i);
				dir = false;
			} else {
				left(i);
				dir = true;
			}
		}
    }
    public static void right(int idx) {
    	int tmp = topnis[idx].pollLast();
    	topnis[idx].addFirst(tmp);
    }
    public static void left(int idx) {
    	int tmp = topnis[idx].pollFirst();
    	topnis[idx].addLast(tmp);
    }
    public static void printv(boolean[] visited) {
    	for (int i = 0; i < visited.length; i++) {
			System.out.print(visited[i] + " ");
		}
    	System.out.println();
    }
    public static void print() {
    	for (int i = 0; i < 4; i++) {
			System.out.println(topnis[i]);
		}
    	System.out.println();
    }
    
}

