import java.util.*;

class LoggerRateLimiter {
	public static void main(String args[]) {
		Logger logger = new Logger();

		System.out.println(logger.shouldPrintMessage(1, "foo"));
		System.out.println(logger.shouldPrintMessage(2, "bar"));
		System.out.println(logger.shouldPrintMessage(3, "foo"));
		System.out.println(logger.shouldPrintMessage(8, "bar"));
		System.out.println(logger.shouldPrintMessage(10, "foo"));
		System.out.println(logger.shouldPrintMessage(11, "foo"));
	}
}

class Logger {
    Map<String, Integer> map;
    int timeout = 10;
    
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message) && map.get(message)>timestamp) {
            return false;
        }
        map.put(message, timestamp+10);
        return true;
    }
}