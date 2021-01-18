import java.util.HashMap;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) {
		Main m = new Main();
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		m.solution(clothes);
	}
	public int answer = 1;
	public HashMap<String, Integer> map = new HashMap<>();
	public int solution(String[][] clothes) {
        for (int i = 0; i < clothes.length; i++) {
			String category = clothes[i][1];
			String item = clothes[i][0];
			if (map.containsKey(category)) {
				int tmp = map.get(category);
				map.replace(category, tmp+1);
			} else map.put(category, 1);
		}
        for (String str : map.keySet()) {
			int tmp = map.get(str)+1;
			answer *= tmp;
		}
        return answer-1;
    }
}