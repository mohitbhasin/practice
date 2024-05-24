class RobotRoomCleaner {
	public static void main(String args[]) {

	}

	public static void cleanRoom(Robot robot) {
		while(robot.move()) {
			robot.turnLeft();
			cleanRoom(robot);
			robot.turnRight();
			cleanRoom(robot);
			robot.clean();	
		}
	}
}

class Robot {
	int i;
	int j;

	
	public boolean move();
  	public void turnLeft();
  	public void turnRight();

  	// Clean the current cell.
  	public void clean();
}