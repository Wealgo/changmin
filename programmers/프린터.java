import java.io.IOException;
import java.util.LinkedList;


class Main {	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		int[] scoville = {2,1,3,2};
		int[] scoville1 = {1, 1, 9, 1, 1, 1};
		int k = 2;
		int k1 = 0;
		System.out.println(m.solution(scoville1, k1));
	}
	public int answer = 0;
	public int idx = 1;
	public LinkedList<Integer> list = new LinkedList<>();
	public int solution(int[] priorities, int location) {
		for (int i = 0; i < priorities.length; i++) {
			list.add(priorities[i]);
		}
        this.idx = location;
        while (!list.isEmpty()) {
			int pick = list.pollFirst();
			if (check(pick)) {
				answer++;
				if (idx == 0) return answer;
				idx--;
			} else {
				list.addLast(pick);
				if (idx == 0) idx = list.size() - 1;
				else idx--;
			}
		}
        return priorities.length-1;
    }
	public boolean check(int pick) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > pick) return false;
		}
		return true;
	}
}