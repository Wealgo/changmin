import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) {
		Main m = new Main();
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] tickets = {{"ICN", "AAA"}, {"AAA", "CCC"}, {"AAA", "DDD"}, {"DDD", "BBB"}, {"BBB", "AAA"}};
		m.solution(tickets);
	}
	public HashMap<String, LinkedList<String>> map = new HashMap<>();
	public int total = 0;
	public LinkedList<String> answers = new LinkedList<>();
	public String[] solution(String[][] tickets) {
		total = tickets.length;
		for (int i = 0; i < tickets.length; i++) {
			String start = tickets[i][0];
			String dest = tickets[i][1];
			if (map.containsKey(start)) map.get(start).add(dest);
			else {
				LinkedList<String> tmp = new LinkedList<>();
				tmp.add(dest);
				map.put(start, tmp);
			}
		}
		LinkedList<String> tmp = new LinkedList<>();
		tmp.add("ICN");
		dfs("ICN", 0, "ICN");
		Collections.sort(answers);
		System.out.println("an:"+answers.get(0));
		String output = answers.get(0);
        String[] answer = new String[total+1];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = output.substring(0, 3);
			output = output.substring(3);
		}
        return answer;
    }
	public void dfs(String dest, int cnt, String path) {
		if (cnt == total) {
			answers.add(path);
			return;
		}
		if (!map.containsKey(dest)) return;
		
		LinkedList<String> list = map.get(dest);
		for (int i = 0; i < list.size(); i++) {
			String start = list.pollFirst();
			if (start.length() != 3) continue;
			StringBuilder sb = new StringBuilder(path);
			sb.append(start);
			dfs(start, cnt+1, sb.toString());
			list.addLast(start);
		}
	}
}