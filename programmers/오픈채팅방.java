import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		String[] p = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(m.solution(p));
	}
	public String[] solution(String[] record) {
		ArrayList<Message> output = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			String command = st.nextToken();
			if (command.equals("Change")) {
				map.put(st.nextToken(), st.nextToken());
				continue;
			}
			if (command.equals("Enter")) {
				String uid = st.nextToken();
				String name = st.nextToken();
				output.add(new Message(uid, 1));
				map.put(uid, name);
			} else {
				output.add(new Message(st.nextToken(), 0));
			}
		}
        String[] answers = new String[output.size()];
        for (int i = 0; i < answers.length; i++) {
        	StringBuilder sb = new StringBuilder();
        	if (output.get(i).in == 1) {
        		sb.append(map.get(output.get(i).uid));
        		sb.append("님이 들어왔습니다.");
        		answers[i] = sb.toString();
			} else {
				sb.append(map.get(output.get(i).uid));
				sb.append("님이 나갔습니다.");
				answers[i] = sb.toString();
			}	
		}
        return answers;
    }
}
class Message {
	String uid;
	int in;
	public Message(String uid, int in) {
		this.in = in;
		this.uid = uid;
	}
}
