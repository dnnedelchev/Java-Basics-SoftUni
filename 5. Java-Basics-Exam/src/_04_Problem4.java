import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


public class _04_Problem4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = Integer.parseInt(sc.nextLine());
		
		Map<String, User> users = new TreeMap<>();
		
		for (int i = 0; i < number; i++) {
			String[]  line = sc.nextLine().split(" ");
			
			
			if(users.containsKey(line[1])) {
				users.get(line[1]).addIP(line[0]);
				users.get(line[1]).addDuration(Long.parseLong(line[2]));
				users.put(line[1], users.get(line[1]));
			}
			else {
				users.put(line[1], new User(line[1], line[0], Long.parseLong(line[2])));
			}
			
			
		}
		
		for (Map.Entry<String, User> user : users.entrySet()) {
			System.out.println(user.getValue().toString());
		}
		
		
	}

}


class User {
	private String name;
	private TreeSet<String> IP;
	private long duration;
	
	public User() {
		IP = new TreeSet<>();
	}
	
	public User(String name, String ip, long duration) {
		this.IP = new TreeSet<>();
		this.name = name;
		this.IP.add(ip);
		this.duration = duration;
	}
	
	public void addIP(String ip) {
		this.IP.add(ip);
	}
	public void addDuration(long dur) {
		this.duration += dur;
	}
	
	public String toString() {
		String allIP = "";
		
			allIP = this.IP.toString();

		
		return this.name + ": " + this.duration + " " + allIP;//+ this.duration + " [" + allIP + " ]";
	}
	
}