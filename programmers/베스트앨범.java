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
	}
	public int[] solution(String[] genres, int[] plays) {
        HashMap<String, LinkedList<Song>> map = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
			if (map.containsKey(genres[i])) {
				LinkedList<Song> list = map.get(genres[i]);
				list.add(new Song(i, plays[i]));
				Collections.sort(list);
				map.replace(genres[i], list);
			} else {
				LinkedList<Song> list = new LinkedList<>();
				list.add(new Song(i, plays[i]));
				map.put(genres[i], list);
			}
		}
        LinkedList<Genre> genre = new LinkedList<>();
        for (String str : map.keySet()) {
			
        	LinkedList<Song> tmp = map.get(str);
			int play = 0;
			for (int i = 0; i < tmp.size(); i++) {
				play = play + tmp.get(i).play;
			}
			genre.add(new Genre(str, play));
		}
        Collections.sort(genre);
        for (String str : map.keySet()) {
			System.out.print(map.get(str).size()+" ");
		}
    	LinkedList<Integer> output = new LinkedList<>();
    	for (int i = 0; i < genre.size(); i++) {
			String gr = genre.get(i).name;
			if (map.get(gr).size() == 1) {
				output.add(map.get(gr).get(0).id);
			} else {
				output.add(map.get(gr).get(0).id);
				output.add(map.get(gr).get(1).id);
			}
		}
    	int[] answer = new int[output.size()];
    	for (int i = 0; i < answer.length; i++) {
			answer[i] = output.get(i);
		}
        return answer;
    }
}
class Genre implements Comparable<Genre>{
	int plays; String name;
	public Genre(String name, int plays) {
		// TODO Auto-generated constructor stub
		this.plays = plays; this.name = name;
	}
	@Override
	public int compareTo(Genre o) {
		// TODO Auto-generated method stub
		return o.plays - this.plays;
	}
}
class Song implements Comparable<Song>{
	int id,play;
	public Song(int id, int play) {
		// TODO Auto-generated constructor stub
		this.id = id; this.play = play;
	}
	@Override
	public int compareTo(Song o) {
		// TODO Auto-generated method stub
		return o.play - this.play;
	}
}