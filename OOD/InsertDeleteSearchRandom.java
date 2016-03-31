public class InsertDeleteSearchRandom {
	private HashMap<String, Integer> map;
	private ArrayList<String> buffer;
	public InsertDeleteSearchRandom() {
		map = new HashMap<>();
		buffer = new ArrayList<>();
	} 	
	public void insert(String s) {
		if(map.containsKey(s)) return;
		int index = buffer.size();
		map.put(s, index);
		buffer.add(s);
	}

	public void remove(String s) {
		if(!map.containsKey(s)) return;
		int index = map.get(s);
		map.remove(s);
		Collections.swap(buffer, index, buffer.size() - 1);
		buffer.remove(buffer.size()-1);
		map.put(buufer[index], index);
	}

	public String getRandom(){
		Random rand = new Random();
		int index = rand.nextInt(0, buffer.size());
		return buffer.get(index);
	}

	public boolean Search(String s) {
		return map.containsKey(s);
	}
	
}