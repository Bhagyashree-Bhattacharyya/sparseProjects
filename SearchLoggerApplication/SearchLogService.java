package games.SearchLoggerApplication;

import java.time.LocalDateTime;
import java.util.*;

public class SearchLogService implements SearchLogServiceInterface{

    private List<SearchLog> searchLogs ;
    private Map<String, Integer> frequencyMap;
    private PriorityQueue<Map.Entry<String, Integer>> maxHeap;
    private BST searchLogBST = new BST();

    public SearchLogService() {
        searchLogs =  new ArrayList<>();
        frequencyMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
    }

    @Override
    public void logSearch(String keyWord) {
        SearchLog newLog = new SearchLog(keyWord);
        searchLogs.add(newLog);
        searchLogBST.insert(newLog);
        frequencyMap.put(keyWord, frequencyMap.getOrDefault(keyWord, 0) + 1);
        maxHeap.clear();
        maxHeap.addAll(frequencyMap.entrySet());
        System.out.println("Search query logged: " + keyWord);
    }

    @Override
    public List<SearchLog> getAllLogs() {
        return searchLogs;
    }

    @Override
    public void printKeyWordFreqCount() {
        frequencyMap.forEach((query, count) -> System.out.println(query + ": " + count));
    }

    @Override
    public String getMostSearchedKeyWord() {
        if(maxHeap.isEmpty()) return "";
        return maxHeap.peek().getKey();
    }

    @Override
    public void printAllLogsInOrder() {
//        System.out.println("Logs in order of timestamp:");
//        searchLogBST.inorder();
        searchLogs.stream()
                .sorted(Comparator.comparing(SearchLog::getTimestamp))
                .forEach(System.out::println);
    }

    @Override
    public List<SearchLog> getLogsInRange(LocalDateTime start, LocalDateTime end) {
//        List<SearchLog> logsInRange = new ArrayList<>();
//        for (SearchLog log : searchLogs) {
//            if (!log.getTimestamp().isBefore(start) && !log.getTimestamp().isAfter(end)) {
//                logsInRange.add(log);
//            }
//        }
//        return logsInRange;
        return searchLogBST.rangeQuery(start, end);
    }

}
