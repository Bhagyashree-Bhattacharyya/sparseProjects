package games.keyAnalyzer;

public class Client {
    public static void main(String[] args) {
//        keyAnalyzer analyzer = new ListKeyAnalyzerImpl();
//        keyAnalyzer analyzer = new SetKeyAnalyzerImpl();
        keyAnalyzer analyzer = new HashMapAnalyzerImpl();

        analyzer.storeKey("java");
        analyzer.storeKey("solidity");
        analyzer.storeKey("cpp");
        analyzer.storeKey("python");
        analyzer.storeKey("java");
        analyzer.storeKey("cpp");
        analyzer.storeKey("cpp");
        analyzer.storeKey("cpp");
        analyzer.storeKey("java");
        analyzer.storeKey("python");
        analyzer.storeKey("java");
        analyzer.storeKey("python");
        analyzer.storeKey("java");
        analyzer.storeKey("solidity");
        analyzer.storeKey("cpp");
        analyzer.storeKey("java");
        analyzer.storeKey("python");
        analyzer.storeKey("solidity");
        analyzer.storeKey("java");
        analyzer.storeKey("cpp");
        analyzer.storeKey("python");
        analyzer.storeKey("java");
        analyzer.storeKey("cpp");
        analyzer.storeKey("python");
        analyzer.storeKey("java");
        analyzer.storeKey("cpp");


        System.out.println(analyzer.fetchKeys());
        System.out.println(analyzer.fetchKeysWithCount());
        System.out.println(analyzer.getTop3());

    }
}
