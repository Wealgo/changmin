
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.AncestorEvent;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) {
		Main m = new Main();
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		System.out.println("output:"+m.solution(begin, target, words));
	}
	public int answer = 0;
	public boolean[] visited;
	public String[] words;
	public int solution(String begin, String target, String[] words) {
        this.words = words.clone();
        visited = new boolean[words.length];
        return bfs(begin, target);
    }
	public int bfs(String begin, String target) {
		LinkedList<String> list = new LinkedList<>();
		list.add(begin);
		while (!list.isEmpty()) {
			int size = list.size();
			for (int t = 0; t < size; t++) {
				String poll = list.poll();
				System.out.println(poll);
				if (poll.equals(target)) return answer;
				for (int i = 0; i < words.length; i++) {
					if (visited[i]) continue;
					if (!isOne(poll, words[i])) continue;
					list.add(words[i]);
					visited[i] = true;
				}
			}
			answer++;
		}
		return 0;
	}
	public boolean isOne(String one, String two) {
		int diff = 0;
		for (int i = 0; i < one.length(); i++) {
			if (diff > 1) return false;
			if (one.charAt(i) != two.charAt(i)) diff++;
		}
		if (diff == 1) return true;
		return false;
	}
}