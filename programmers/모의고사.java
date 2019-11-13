import java.util.LinkedList;

class Solution {
    public static int a;
    public static int b;
    public static int c;
    public static int[] solution(int[] answers) {
    	//1~3번 학생 채점.
        a(answers);
    	b(answers);
    	c(answers);
    	LinkedList<Integer> list = new LinkedList<>();
    	list.add(a);
    	list.add(b);
    	list.add(c);
    	int max = 0;
    	//최대값 뽑아내고.
    	for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i)) {
				max = list.get(i);
			}
		}
    	//동점인 학생들 뽑아내자.
    	LinkedList<Integer> sibal = new LinkedList<>();    	
    	for (int i = 0; i < list.size(); i++) {
			if (max == list.get(i)) {
				sibal.add(i);
			}
		}
    	
    	int[] answer = new int [sibal.size()];
    	for (int i = 0; i < answer.length; i++) {
			answer[i] = sibal.get(i)+1;
		}
        return answer;
    }
    //1번 학생 채점.
    public static void a(int[] answers) {
        int[] tmp = {1,2,3,4,5};
        int sibal = 0;
        int output = 0;
        for (int i = 0; i < answers.length; i++) {
			if (sibal > tmp.length-1) {
				sibal = 0;
			}
			if (tmp[sibal] == answers[i]) {
				output++;
			}
			sibal = sibal+1;
		}
        a = output;
    }
    //2번 학생 채점.
    public static void b(int[] answers) {
        int[] tmp = {2,1,2,3,2,4,2,5};
        int sibal = 0;
        int output = 0;
        for (int i = 0; i < answers.length; i++) {
			if (sibal > tmp.length-1) {
				sibal = 0;
			}
			if (tmp[sibal] == answers[i]) {
				output++;
			}
			sibal = sibal+1;
		}
        b = output;
    }
    //3번 학생 채점.
    public static void c(int[] answers) {
        int[] tmp = {3,3,1,1,2,2,4,4,5,5};
        int sibal = 0;
        int output = 0;
        for (int i = 0; i < answers.length; i++) {
			if (sibal > tmp.length-1) {
				sibal = 0;
			}
			if (tmp[sibal] == answers[i]) {
				output++;
			}
			sibal = sibal+1;
		}
        c = output;
    }
}