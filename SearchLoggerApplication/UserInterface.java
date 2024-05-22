package games.SearchLoggerApplication;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private SearchLogServiceInterface service;

//    public UserInterface(SearchLogService service) {
//        this.service = service;
//    }
    // eager initialization

    public UserInterface() {
        // Constructor without parameters, service will be lazily initialized
    }

    private SearchLogServiceInterface startService() {
        if (service == null) {
            service = new SearchLogService();
        }
        return service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Enter search keyword");
            System.out.println("2. View all search logs");
            System.out.println("3. View search query counts");
            System.out.println("4. View most searched keyword");
            System.out.println("5. View all logs in order");
            System.out.println("6. View logs in range");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter search keyword: ");
                    String query = scanner.nextLine();
                    startService().logSearch(query);
                    break;
                case 2:
                    System.out.println("Search Logs:");
                    for (SearchLog log : startService().getAllLogs()) {
                        System.out.println(log);
                    }
                    break;
                case 3:
                    System.out.println("Search keyword Counts:");
                    startService().printKeyWordFreqCount();;
                    break;
                case 4:
                    String mostSearchedQuery = startService().getMostSearchedKeyWord();
                    System.out.println("Most Searched keyword: " + mostSearchedQuery);
                    break;
                case 5:
                    startService().printAllLogsInOrder();
                    break;
                case 6:
                    System.out.print("Enter start timestamp (yyyy-MM-ddTHH:mm:ss): ");
                    LocalDateTime start = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Enter end timestamp (yyyy-MM-ddTHH:mm:ss): ");
                    LocalDateTime end = LocalDateTime.parse(scanner.nextLine());
                    List<SearchLog> logsInRange = startService().getLogsInRange(start, end);
                    System.out.println("Logs in range:");
                    for (SearchLog log : logsInRange) {
                        System.out.println(log);
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
