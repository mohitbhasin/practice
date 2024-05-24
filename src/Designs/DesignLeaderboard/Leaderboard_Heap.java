class Leaderboard_Heap {
    Map<Integer, Integer> playerScoreMap;
    public Leaderboard_Heap() {
        playerScoreMap = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if(!playerScoreMap.containsKey(playerId)) {
            playerScoreMap.put(playerId, 0);
        }
        playerScoreMap.put(playerId, playerScoreMap.get(playerId)+score);
    }
    
    public int top(int K) {
        PriorityQueue<Integer> playerScoreQue = new PriorityQueue<>();
        
        for(Map.Entry<Integer, Integer> entry: playerScoreMap.entrySet()) {
            playerScoreQue.offer(entry.getValue());
            if(playerScoreQue.size()>K) playerScoreQue.poll();
        }
        
        int total=0;
        
        for(int score: playerScoreQue) total+=score;
        return total;
    }
    
    public void reset(int playerId) {
        playerScoreMap.put(playerId, 0);
    }
}