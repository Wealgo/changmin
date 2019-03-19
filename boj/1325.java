
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
public class Main{
	public static LinkedList<Integer> list;
	public static HashMap<Integer, LinkedList<Integer>> newMap;
    public static void main(String[] args) throws IOException {
    	newMap = new HashMap<>();
    	list = new LinkedList<>();
    	Scanner sc = new Scanner(System.in);
    	int max = sc.nextInt();
    	int num = sc.nextInt();
    	for (int i = 0; i < num; i++) {
    		int x = sc.nextInt();
    		int y = sc.nextInt();
			if (newMap.containsKey(y)) {
				LinkedList<Integer> tmp = newMap.get(y);
				tmp.add(x);
				newMap.put(y, tmp);
			} else {
				LinkedList<Integer> tmp = new LinkedList<>();
				tmp.add(x);
				newMap.put(y, tmp);
			}
		}
    	LinkedList<Integer> output = new LinkedList<>();
    	int tmp = 0;
    	output.add(0);
    	for (int i = 0; i < max+1; i++) {
			list = new LinkedList<>();
    		dfs(i);
    		if (tmp < list.size()) {
				tmp = list.size();
				output = new LinkedList<>();
				output.add(i);
			} else if (tmp == list.size()) {
				output.add(i);
			}
		}
    	for (int i = 0; i < output.size(); i++) {
			System.out.print(output.get(i));
		}
    }
    public static void dfs(int input) {
    	if (list.contains(input)) {
			
		} else {
	    	list.add(input);
	    	if (!newMap.containsKey(input)) {
				
			} else {
		    	for (int i = 0; i < newMap.get(input).size(); i++) {
		    		dfs(newMap.get(input).get(i));
				}
			}
	    }
    }
    
}