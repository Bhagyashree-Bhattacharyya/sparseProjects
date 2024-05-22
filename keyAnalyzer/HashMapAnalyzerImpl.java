package games.keyAnalyzer;

import java.util.*;

public class HashMapAnalyzerImpl implements keyAnalyzer{


//    private HashMap<String, Integer> keyWithCountMap;
//
//    public HashMapAnalyzerImpl(){
//        keyWithCountMap = new HashMap<>();
//    }
//
//    @Override
//    public void storeKey(String key) {
//        keyWithCountMap.put(key, keyWithCountMap.getOrDefault(key, 0)+1);
//    }
//
//    @Override
//    public List<String> fetchKeys() {
//        return new ArrayList<>(keyWithCountMap.keySet());
//    }
//
//    @Override
//    public Map<String, Integer> fetchKeysWithCount(){
//    return keyWithCountMap;
//    }




    private HashMap<String, keyWord> keyWithCountMap;
    private Queue<keyWord> pqueue;

    public HashMapAnalyzerImpl() {
        keyWithCountMap = new LinkedHashMap<>();
        pqueue = new PriorityQueue<>(MyCmp);
    }

    Comparator<keyWord> MyCmp = new Comparator<keyWord>() {
        @Override
        public int compare(keyWord k1, keyWord k2) {
            return Integer.compare(k1.getCount(), k2.getCount());
        }
    };

    @Override
    public void storeKey(String key) {
        if(keyWithCountMap.containsKey(key)){
            keyWord keyWord = keyWithCountMap.get(key);
            pqueue.remove(keyWord);
            keyWord newKeyWord = new keyWord(key, keyWithCountMap.get(key).getCount()+1);
            keyWithCountMap.put(key, newKeyWord);
            pqueue.add(newKeyWord);
        } else {
            keyWord newKeyWord = new keyWord(key, 1);
            keyWithCountMap.put(key, newKeyWord);
            pqueue.add(newKeyWord);
        }
    }

    @Override
    public List<String> fetchKeys() {
        return new ArrayList<>(keyWithCountMap.keySet());
    }

    @Override
    public List<keyWord> getTop3() {
        List<keyWord> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(pqueue.poll());
        }
        return list;
    }
}
