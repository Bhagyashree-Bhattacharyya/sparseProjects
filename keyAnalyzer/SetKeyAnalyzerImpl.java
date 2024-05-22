package games.keyAnalyzer;

import java.util.*;

public class SetKeyAnalyzerImpl implements keyAnalyzer{

    private Set<String> keySet;

    public SetKeyAnalyzerImpl(){
        keySet = new HashSet<>();
    }

    @Override
    public void storeKey(String key) {
        keySet.add(key);
    }

    @Override
    public List<String> fetchKeys() {
//        return List.of(keySet.toString());
        return List.copyOf(keySet);
    }
}
