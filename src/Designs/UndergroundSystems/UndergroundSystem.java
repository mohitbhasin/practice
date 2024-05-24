import java.util.*;

class UndergroundSystem {
    Map<String, Map<String, List<Integer>>> sourceDestMap;
    Map<Integer, Integer> startTimeMap;
    Map<Integer, String> sourceMap;
    public UndergroundSystem() {
        sourceDestMap = new HashMap<>();
        startTimeMap = new HashMap<>();
        sourceMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        startTimeMap.put(id, t);
        if(!sourceDestMap.containsKey(stationName)) sourceDestMap.put(stationName, new HashMap<>());
        sourceMap.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String sourceStation = sourceMap.get(id);
        int sTime = startTimeMap.get(id);
        Map<String, List<Integer>> tempMap = sourceDestMap.get(sourceStation);
        if(!tempMap.containsKey(stationName)) {
            tempMap.put(stationName, new ArrayList<>());
        }
        tempMap.get(stationName).add(t - sTime);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Integer> times = sourceDestMap.get(startStation).get(endStation);
        double sum = 0;
        for(int time: times) {
            sum+=time;
        }
        return sum/times.size();
    }
}