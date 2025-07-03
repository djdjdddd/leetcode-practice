package book.D_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P021_오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = solution(record);
		System.out.println(Arrays.toString(result));
	}

	static String[] solution(String[] record){
		Map<String, String> map = new HashMap<>();
		for(String r : record){
			String[] split = r.split(" ");
			String s1 = split[0];
			String uid = split[1];

			if("Enter".equals(s1) || "Change".equals(s1)){
				String nick = split[2];
				map.put(uid, nick);
			}
		}
//		System.out.println(map);

		List<String> list = new ArrayList<>();
		for(String r : record){
			String[] split = r.split(" ");
			String s1 = split[0];
			String uid = split[1];

			if("Enter".equals(s1)) {
				String nick = map.get(uid);
				list.add("\"" + nick + "님이 들어왔습니다.\"");
			}else if("Leave".equals(s1)){
				String nick = map.get(uid);
				list.add("\"" + nick + "님이 나갔습니다.\"");
			}
		}
//		System.out.println(list);

		String[] result = new String[list.size()];
		for(int i=0; i<list.size(); i++){
			result[i] = list.get(i);
		}

		return result;
	}
}
