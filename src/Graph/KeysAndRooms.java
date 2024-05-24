import java.util.*;

class KeysAndRooms {
	public static void main(String args[]) {
		// Integer[][] roomArray = {{1,3},{3,0,1},{2},{0}};
		Integer[][] roomArray = {{1},{2},{3},{}};
		List<List<Integer>> rooms = new ArrayList<>();
		for(Integer[] room: roomArray) {
			rooms.add(Arrays.asList(room));
		}
		System.out.println(canVisitAllRooms(rooms));
	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = new HashSet<>();
        visitRooms(0, rooms, visitedRooms);
        return visitedRooms.size() == rooms.size();
    }
    
    public static void visitRooms(int curr, List<List<Integer>> rooms, Set<Integer> visited) {
        if(visited.contains(curr)) {
            return;
        }
        visited.add(curr);
        for(int key: rooms.get(curr)) {
            visitRooms(key, rooms, visited);
        }
    }
}