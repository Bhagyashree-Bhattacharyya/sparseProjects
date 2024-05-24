package games.FlightAggregator;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<FlightData> getFlights(String src, String dest, Date jDate);
}
