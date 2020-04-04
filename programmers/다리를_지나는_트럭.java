import java.util.LinkedList;


/**
 * 만만해보인다고 키보드부터 잡지 말자.
 * 침착하게 공책으로 해보자!
 * @author quadcore
 *
 */
public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int[] truck_weights = {10,1,2,3,7,3};
		System.out.println("output:"+m.solution(10, 10, truck_weights));
	}
	public int bridge_length;
	public int weight;
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        this.bridge_length = bridge_length;
        this.weight = weight;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
			list.add(truck_weights[i]);
		}
        //Collections.sort(list);
        LinkedList<Integer> bridge = new LinkedList<>();
        bridge.add(list.pollFirst());
        int nw = bridge.getFirst();
        while (!bridge.isEmpty()) {
        	answer++;
        	if (bridge.size() >= bridge_length) {
        		nw -= bridge.getLast();
				bridge.pollLast();
			} 
			//add
			if (list.isEmpty()) {
				bridge.addFirst(0);
			} else {
				if (nw + list.getFirst() > weight) {
					bridge.addFirst(0);
				} else {
					nw += list.getFirst();
					bridge.addFirst(list.pollFirst());
				}
			}
        	if (nw == 0) {
				break;
			}
		}
        return answer;
    }
}