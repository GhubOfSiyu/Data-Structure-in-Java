class UserManager {
	private static valotile UserManager instance = null;
	private UserManager() {}
	private HashSet<Integer> onlineUser = new HashSet<Integer>();
	public static getInstance() {
		if(instance == null) {
			synchronzied(UserManager.class) {
				if(instance == null) {
					instance = new UserManager();
				}
			}
		}
		return instance;
 	}

 	public void registerUser(User u) {}
 	public void deleteUser(User u) {}

 	public void addFriend(int id) {}
 	public void removeFriend(int id) {}

 	public void requestAdd(int id) {}
 	public void rejectAdd(int id) {}

 	public void sendPrivateMsg(int from, int to) {}
 	private void sendGroupMsg(int from, int to) {}


}

class User {

}


class Mesage {

}