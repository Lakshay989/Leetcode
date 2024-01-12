import java.util.HashMap;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_Q981 {
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeBasedKeyValueStore_Q981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        Integer floorKey = map.get(key).floorKey(timestamp);
        // Return searched time's value, if exists.
        if (floorKey != null) {
            return map.get(key).get(floorKey);
        }

        return "";
    }

    public static void main(String[] args) {
        // Create TimeMap object
        TimeBasedKeyValueStore_Q981 timeMap = new TimeBasedKeyValueStore_Q981();

        // Test cases
        timeMap.set("key1", "value1", 1);
        timeMap.set("key1", "value2", 3);
        timeMap.set("key1", "value3", 5);

        System.out.println("Test 1: " + timeMap.get("key1", 0));  // Output: ""
        System.out.println("Test 2: " + timeMap.get("key1", 2));  // Output: "value1"
        System.out.println("Test 3: " + timeMap.get("key1", 4));  // Output: "value2"
        System.out.println("Test 4: " + timeMap.get("key1", 6));  // Output: "value3"

        timeMap.set("key2", "value4", 10);

        System.out.println("Test 5: " + timeMap.get("key2", 5));  // Output: ""
        System.out.println("Test 6: " + timeMap.get("key2", 12)); // Output: "value4"
    }
}
