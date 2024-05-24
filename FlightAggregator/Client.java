package games.FlightAggregator;

import java.util.*;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        List<FlightService> listOfFlightService = new ArrayList<>();
        FlightService service1 = new AirIndiaFlightServiceImpl();
        FlightService service2 = new SpiceJetFlightServiceImpl();
        FlightService service3 = new IndigoFlightServiceImpl();
        listOfFlightService.add(service1);
        listOfFlightService.add(service2);
        listOfFlightService.add(service3);

        // Executor service
        ExecutorService mainService = Executors.newFixedThreadPool(listOfFlightService.size());

//        FlightTask task1 = new FlightTask("delhi", "goa", new Date(), service1);
//        FlightTask task2 = new FlightTask("delhi", "goa", new Date(), service2);
//        FlightTask task3 = new FlightTask("delhi", "goa", new Date(), service3);

        long startTime = System.currentTimeMillis();
        // here are 3 ways -- need to comment out any 2 before run
        // 1st way
//        List<Future<List<FlightData>>> output1 = new ArrayList<>();
//        output1.add(mainService.submit(task1));
//        output1.add(mainService.submit(task2));
//        output1.add(mainService.submit(task3));

        // 2nd way
//        List<Callable<List<FlightData>>> resultList = new ArrayList<>();
//        resultList.add(task1);
//        resultList.add(task2);
//        resultList.add(task3);
//        List<Future<List<FlightData>>> output2 = mainService.invokeAll(resultList);

        // 3rd way --- handles task creation and submit both in one go
        List<Callable<List<FlightData>>> resultList2 = new ArrayList<>();
        String from = "delhi";
        String to = "goa";
        Date date = new Date();
        for (FlightService flightService : listOfFlightService) {
            FlightTask task = new FlightTask(from, to, date, flightService);
            resultList2.add(task);
        }
        List<Future<List<FlightData>>> output3 = mainService.invokeAll(resultList2);

        output3.forEach(data -> {
            try {
                System.out.println(data.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using ExecutorService: " + (endTime - startTime) + " ms");

        mainService.shutdown();

        // Parallel streaming
        startTime = System.currentTimeMillis();
        List<FlightData> flightDataList = listOfFlightService.parallelStream()
                .map(service -> new FlightTask(from, to, date, service))
                .map(task -> {
                    try {
                        return task.call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .flatMap(List::stream)
                .toList();

        endTime = System.currentTimeMillis();
        System.out.println("Time taken using Parallel Stream: " + (endTime - startTime) + " ms");

        flightDataList.forEach(System.out::println);
    }
}
