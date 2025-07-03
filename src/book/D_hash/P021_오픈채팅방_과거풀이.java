package book.D_hash;

import java.util.*;

public class P021_오픈채팅방_과거풀이 {

	public static void main(String[] args) {

	}

	static String[] solution(String[] record){
		int leng = record.length;

		// 1. record를 읽어서 Message 객체 만들기??
		Message[] messages = new Message[leng];
		Map<String, List<Integer>> map = new HashMap<>();
		Map<String, String> finalMap = new HashMap<>();     // 최종 닉네임을 기억해두기 위한 맵

		for(int i=0; i<leng; i++){
			String[] r = record[i].split(" ");
			String status = r[0];
			String uid = r[1];
			String nick = null;
			if(r.length == 3){
				nick = r[2];
			}

			if("Enter".equals(status) || "Change".equals(status)){
				finalMap.put(uid, nick);
			}

			messages[i] = new Message(uid, nick, status);

			if(map.containsKey(uid)){
				List<Integer> idxList = map.get(uid);
				idxList.add(i);
				map.put(uid, idxList);
			}else{
				List<Integer> idxList = new ArrayList<Integer>();   //★★ 아오 병신아. 왜 여기에 i를 안 더하고 그냥 넣었어 ㅡㅡ
				idxList.add(i);
				map.put(uid, idxList);
			}
		}

		// 변경하기
		// uid(키)로 인덱스 list를 얻고, 그 인덱스에 해당하는 Message 객체를 얻고, 그 놈의 닉네임을 바꾸면 되지 않을까?
		for(Map.Entry<String, String> entry : finalMap.entrySet()){
			String uid = entry.getKey();
			String finalNick = entry.getValue();

			//★★★여기까진 아주 잘 됐는데?? -> 처음에 빈 List를 넣은게 잘못된 거였음. 빈 걸 넣을게 아니고 i는 add했어야 했는데...
			// System.out.println("uid : " + uid);
			// System.out.println("finalNick : " + finalNick);

			for(int idx : map.get(uid)){
				//System.out.println(idx);
				messages[idx].nick = finalNick;
			}
		}

		// System.out.println(messages[0].toString());
		// System.out.println(messages[1].toString());
		// System.out.println(messages[2].toString());
		// System.out.println(messages[3].toString());
		// System.out.println(messages[0].toString());

		// answer 만들기
		List<String> answerList = new ArrayList<>();

		for(int i=0; i<leng; i++){
			Message m = messages[i];
			if("Change".equals(m.status)){
				continue;
			}

			String status = "";

			if("Enter".equals(m.status)){
				status = "들어왔습니다.";
			}else{
				status = "나갔습니다.";
			}

			String full = m.nick + "님이 " + status;
			answerList.add(full);
		}

		// List를 배열로 바꾸기
		int size = answerList.size();
		String[] answer = new String[size];
		for(int i=0; i<size; i++){
			answer[i] = answerList.get(i);
		}

		return answer;
	}

	// Message 객체
	static class Message{
		String uid;
		String nick;
		String status;

		Message(String uid, String nick, String status){
			this.uid = uid;
			this.nick = nick;
			this.status = status;
		}

		@Override
		public String toString(){
			return "uid = " + uid + " nick = " + nick + " status = " + status;
		}
	}
}

