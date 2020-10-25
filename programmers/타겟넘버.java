
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		Main m = new Main();
		System.out.println(m.solution(numbers, target));
	}
	int answer = 0;
	int target;
	LinkedList<Integer> list;
	public int solution(int[] numbers, int target) {
        this.target = target;
		list = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) list.add(numbers[i]);
		backtracking(0, 0);
        return answer;
    }
	public void backtracking(int idx, int cnt) {
		if (idx == list.size()) {
			if (cnt == target) answer++;
			return;
		}
		backtracking(idx+1, cnt - list.get(idx));
		backtracking(idx+1, cnt + list.get(idx));
	}
}