package problems;

public class LinkedNode {
	private LinkedNode nextNode;
	private int data;
	
	LinkedNode(int data) {
		this.data=data;
	}
	
	public LinkedNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(LinkedNode nextNode) {
		this.nextNode = nextNode;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}
