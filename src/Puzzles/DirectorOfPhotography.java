import java.util.*;

// TODO
class DirectorOfPhotography{
	public static void main(String args[]) {

	}

	public int getArtisticPhotographCount(int N, String C, int X, int Y) {
	    int count = 0;
	    ArrayList<Integer>[] pos = new ArrayList[3];
	    Arrays.fill(pos, new ArrayList<>());
	    for(int i=0; i<C.length(); i++) {
	      char c = C.charAt(i);
	      if(c=='P') {
	      	pos[0].add(i);
	      } else if(c=='A') {
	      	pos[1].add(i);
	      } else if(c=='B') {
	      	pos[2].add(i);
	      }
	    }

	    for(int p_pos: pos[0]) {

	    }
	    
	    return count;
  	}
}