import java.util.*;

class SnapshotArray {
    TreeMap<Integer, Integer>[] snapshotArr;
    int snap_id;
    public SnapshotArray(int length) {
        snapshotArr = new TreeMap[length];
        for(int i=0; i<length; i++) {
            TreeMap map = new TreeMap<>();
            map.put(0,0);
            snapshotArr[i] = map;
        }
        snap_id=0;
    }
    
    public void set(int index, int val) {
        snapshotArr[index].put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        System.out.println(index+"--"+snapshotArr[index].keySet());
        return snapshotArr[index].floorEntry(snap_id).getValue();
    }

    // int snapId = 0;
    // TreeMap<Integer, Integer>[] historyRecords;
    
    // public SnapshotArray(int length) {
    //     historyRecords = new TreeMap[length];
    //     for (int i = 0; i < length; i++) {
    //         historyRecords[i] = new TreeMap<Integer, Integer>();
    //         historyRecords[i].put(0, 0);
    //     }
    // }

    // public void set(int index, int val) {
    //     historyRecords[index].put(snapId, val);
    // }

    // public int snap() {
    //     return snapId++;
    // }

    // public int get(int index, int snapId) {
    //     return historyRecords[index].floorEntry(snapId).getValue();
    // }
}