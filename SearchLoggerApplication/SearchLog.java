package games.SearchLoggerApplication;

import java.time.LocalDateTime;

public class SearchLog {
    private String keyWord;
    private LocalDateTime timestamp;

    public SearchLog(String query) {
        this.keyWord = query;
        this.timestamp = LocalDateTime.now();
    }

    public String getKey() {
        return keyWord;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "SearchLog{" +
                "query='" + keyWord + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }    
}
