import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
	public static HashMap<Integer, LinkedList<Integer>> graph;
	public static int[][] output;
    public static int n;
	private static Scanner sc;
    public static void main(String[] args) {
    	graph = new HashMap<>();
    	sc = new Scanner(System.in);
    	n = sc.nextInt();
    	output = new int [n][n];
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (sc.nextInt() == 1) {
					if (graph.containsKey(i)) {
						graph.get(i).add(j);
					} else {
						LinkedList<Integer> list = new LinkedList<>();
						list.add(j);
						graph.put(i, list);
					}
				}
			}
		}
    	
    	/**
    	for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				output[i][j] = dfs(i, j);
			}
		}
    	for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				System.out.print(output[i][j]);
			}
			System.out.println();
		}/**/
    	Main m = new Main();
    	System.out.println(graph);
    	System.out.println("output:"+m.dfs(0, 0));
    }
    public int dfs(int start, int end) {
    	System.out.println("in:"+start);
    	if (!graph.containsKey(start)) {
    		return 0;
		}
    	//not working this if statement
		if (graph.get(start).contains(end)) {
			System.out.println("sibal");
			return 1;
		} else {
			for (int i = 0; i < graph.get(start).size(); i++) {
					dfs(graph.get(start).get(i), end);
			}
		}
		return 0;
    }

}

