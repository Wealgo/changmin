import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int k, l;
	public static int[] map = new int[100000000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 1; i <= l; i++) map.put(br.readLine(), i);
		
		LinkedList<String> keySetList = new LinkedList<>(map.keySet());
		
        Collections.sort(keySetList, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		// TODO Auto-generated method stub
        		return map.get(o1).compareTo(map.get(o2));
        	}
		});
        for (int i = 0; i < k; i++) {
        	if (keySetList.isEmpty()) break;
        	bw.write(keySetList.pollFirst());
        	bw.newLine();
        }
        bw.flush();
	}
}