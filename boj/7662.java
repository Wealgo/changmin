import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * not EZ
 * @author quadcore
 */
class Main {
	public static int n;
	public static int[] mem = new int[12];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			TreeMap<Long, Long> treeMap = new TreeMap<>();
			
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				if (command.equals("I")) {
					Long input = Long.parseLong(st.nextToken());
					if (treeMap.containsKey(input)) {
						treeMap.put(input, treeMap.get(input)+1);
					} else treeMap.put(input, 1L);
				} else {
					if (treeMap.isEmpty()) continue;
					int dCommand = Integer.parseInt(st.nextToken());
					if (dCommand == 1) {
						long tmp = treeMap.lastKey();
						if (treeMap.get(tmp) == 1) treeMap.remove(tmp);
						else treeMap.put(tmp, treeMap.get(tmp)-1);
					} else {
						long tmp = treeMap.firstKey();
						if (treeMap.get(tmp) == 1) treeMap.remove(tmp);
						else treeMap.put(tmp, treeMap.get(tmp)-1);
					}
				}
			}
			if (treeMap.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
			}
		}
	}

}