
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public boolean solution(String[] phone_book) {    
        List<String> list = Arrays.asList(phone_book);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            String tmp = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j).contains(tmp)) {
                    return false;
                }
            }
        }
        return true;
    }
}