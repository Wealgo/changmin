import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    	LinkedList<Integer> output = new LinkedList<>();
        //작업의 리스트.
    	LinkedList<Integer> pro = new LinkedList<>();
        //스피드의 리스트.
    	LinkedList<Integer> spd = new LinkedList<>();
    	for (int i = 0; i < progresses.length; i++) {
			pro.add(progresses[i]);
			spd.add(speeds[i]);
		}
    	int idx = 0;
    	//모든 작업이 완료될때까지.
    	while (idx <= progresses.length-1) {
    		//각각의 작업마다 스피드를 ++해주자.
    		for (int i = idx; i < spd.size(); i++) {
				pro.set(i, pro.get(i)+spd.get(i));
			}
    		//만약 100%이상이 되었다면 continue;
    		if (pro.get(idx) < 100) continue;
    		int tmp = 0;
    		//전체 리스트를 돌면서.
    		for (int i = idx; i < speeds.length; i++) {
				//만약 100%가 넘는 작업리스트들이 있다면.
    			if (pro.get(i) >= 100) {
    				//idx를 새로 지정해주자.
					idx = idx + 1;
					tmp = tmp + 1;
				} else {
					//아니라면 pass.
					break;
				}
			}
    		output.add(tmp);
		}
    	
    	int[] answer = new int[output.size()];
    	for (int i = 0; i < answer.length; i++) {
			answer[i] = output.get(i);
		}
        return answer;
    }
}