package games.SearchLoggerApplication;

import java.time.LocalDateTime;
import java.util.*;

public interface SearchLogServiceInterface {
    void logSearch(String query);
    List<SearchLog> getAllLogs();
    void printKeyWordFreqCount();
    String getMostSearchedKeyWord();
    void printAllLogsInOrder();
    List<SearchLog> getLogsInRange(LocalDateTime start, LocalDateTime end);
}
