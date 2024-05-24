import java.util.*;

public class WebsiteOccurrences {
    static LinkedList<String> data;
    static Map<String, Pair> occurencesMap;
    public static void main(String args[]) {
        String[] sites = {"bloomberg.com", "google.com", "facebook.com", "bloomberg.com", "instagram.com"};
        data = new LinkedList<>();
        occurencesMap = new HashMap<>();
        List<String> websites = new ArrayList<>();
        for(String website: sites) {
            websites.add(website);
        }
        getData(websites);
        System.out.println(topKFrequent(3));
    }

    public static void getData(List<String> websites) {
        for(String website: websites) {
            Pair pair;
            LinkedList<String> node = new LinkedList();
            node.add(website);
            data.addAll(node);
            if(!occurencesMap.containsKey(website)) {
                pair = new Pair(1, node);
                occurencesMap.put(website, pair);
            } else {
                pair = occurencesMap.get(website);
                pair.count++;
            }
        }
    }

    public static List<String> topKFrequent(int k) {
        List<String> result = new ArrayList<>();

        int index=0;
        while(result.size()<=k && index<data.size()) {
            String website = data.get(index++);
            if(occurencesMap.get(website).count==1) {
                result.add(website);
            }
        }
        return result;
    }

    static class Pair {
        int count;
        LinkedList node;

        Pair(int count, LinkedList node) {
            this.count = count;
            this.node = node;
        }
    }
}