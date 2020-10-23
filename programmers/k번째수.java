
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(m.solution(array, commands));
	}
	LinkedList<Integer> list;
	public int[] solution(int[] array, int[][] commands) {
        int[] output = new int[commands.length];
		list = new LinkedList<>();
		for (int i = 0; i < array.length; i++) list.add(array[i]);
		LinkedList<Integer> tmp;
		for (int i = 0; i < commands.length; i++) {
			tmp = (LinkedList<Integer>) list.clone();
			List<Integer> subList = tmp.subList(commands[i][0]-1, commands[i][1]);
			Collections.sort(subList);
			output[i] = subList.get(commands[i][2]-1);
		}
        return output;
    }
}