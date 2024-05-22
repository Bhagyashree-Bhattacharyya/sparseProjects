package games.keyAnalyzer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListKeyAnalyzerImpl implements keyAnalyzer{

    private List<String> keys;

    public ListKeyAnalyzerImpl(){
//        keys = new ArrayList<>();
        keys = new LinkedList<>();
    }


    @Override
    public void storeKey(String key) {
        keys.add(key);
    }

    @Override
    public List<String> fetchKeys() {
        return keys;
    }
}
