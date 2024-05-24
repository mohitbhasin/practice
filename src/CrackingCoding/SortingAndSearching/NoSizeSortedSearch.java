import java.util.*;

class NoSizeSortedSearch {
	public static void main(String args[]) {
		Listy list = new Listy();
		list.add(12);list.add(14);list.add(15);list.add(19);list.add(25);list.add(25);list.add(26);list.add(26);list.add(28);list.add(33);list.add(35);list.add(35);list.add(35);list.add(36);list.add(36);list.add(36);list.add(36);list.add(36);list.add(37);list.add(38);list.add(41);list.add(44);list.add(46);list.add(47);list.add(54);list.add(57);list.add(58);list.add(58);list.add(59);list.add(65);list.add(65);list.add(66);list.add(67);list.add(67);list.add(68);list.add(69);list.add(70);list.add(72);list.add(75);list.add(75);list.add(76);list.add(78);list.add(83);list.add(83);list.add(83);list.add(95);list.add(96);list.add(97);list.add(97);list.add(98);
		System.out.println(search(list, 25));
	}

	public static int search(Listy list, int value) {
		int index=1;
		while(list.elementAt(index)!=-1 && value>list.get(index)) {
			index*=2;

		}
		return search(list, value, index/2, index);
	}

	public static int search(Listy list, int value, int lower, int upper) {
		int mid=0;
		while(lower<=upper) {
			mid = (upper + lower)/2;
			if(list.get(mid)==value) {
				return mid;
			}
			else if(list.get(mid)>value) {
				upper=mid-1;
			} else {
				lower=mid+1;
			}
		}
		return -1;
	}
}

class Listy {
	ArrayList<Integer> list;
	Listy() {
		list = new ArrayList<Integer>();
	}

	public int elementAt(int i) {
		if(i>list.size()-1) {
			return -1;
		}
		return list.get(i);
	}

	public void add(int value) {
		list.add(value);
	}

	public int get(int index) {
		return elementAt(index);
	}
}