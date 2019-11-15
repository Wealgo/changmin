import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * 문제의 점화식을 알면 쉽게 풀 수 있다.
 * (종류의 의상 갯수+1)*(종류의 의상 갯수+1)...(종류의 의상 갯수+1)-1
 */
public class Main {
	public static int output,n,m;
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String wear = st.nextToken();
				String kind = st.nextToken();
				if (map.containsKey(kind)) {
					map.replace(kind, map.get(kind)+1);
				} else {
					map.put(kind, 1);
				}
			}
			int output = 1;
			for (String str : map.keySet()) {
				int sibal = map.get(str);
				output = output * (sibal+1);
			}
			System.out.println(output-1);
		}
	}
}