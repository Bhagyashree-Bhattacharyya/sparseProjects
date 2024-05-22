package games.keyAnalyzer;

public class keyWord {

    private String key;
    private int count;
    public keyWord(String key, int count){
        this.key = key;
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "keyWord{" +
                "key='" + key + '\'' +
                ", count=" + count +
                '}';
    }
}
