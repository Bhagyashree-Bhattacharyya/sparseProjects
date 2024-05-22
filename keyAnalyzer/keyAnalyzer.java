package games.keyAnalyzer;

import java.util.*;

public interface keyAnalyzer {
    default Map<String, Integer> fetchKeysWithCount(){ return null;};
    void storeKey(String key);
    List<String> fetchKeys();
    default List<keyWord> getTop3() {return null;}
}
