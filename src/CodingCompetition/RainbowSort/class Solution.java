class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.getInt();
        
        for(int test=0; test<numTests; i++) {
            int numCards = scanner.nextInt();
            List<Integer> cards = new ArrayList<>();
            for(int card=0; card<numCards; card++) {
                cards.add(scanner.nextInt());
            }
            List<Integer> result = rainbowSort(cards);
            String output;
            if(result == null) {
                output = "IMPOSSIBLE";
            } else {
                output = result.toString();
            }
            System.out.println("Case #" + test + ": " + output);
        }
    }
    
    public List<Integer> rainbowSort(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        List<Intger> result = new ArrayList<>();
        set.add(list.get(0));
        result.add(list.get(0));
        
        for(int i=1; i<list.length(); i++) {
            if(list.get(i)!=list.get(i-1)) {
                if(set.contains(list.get(i)) {
                    return null;
                } else {
                    result.add(list.get(i));
                }
            }
        }
        
        return result;
    }
}