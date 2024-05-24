package games.FlightAggregator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpiceJetFlightServiceImpl implements FlightService{
    @Override
    public List<FlightData> getFlights(String src, String dest, Date jDate) {
        // third party SpiceJet API
        List<FlightData> flights = new ArrayList<>();
        flights.add(new FlightData(src, dest, jDate, 200, "spiceJet", 5));
        flights.add(new FlightData(src, dest, jDate, 200, "spiceJet", 6));
        flights.add(new FlightData(src, dest, jDate, 200, "spiceJet", 7));
        flights.add(new FlightData(src, dest, jDate, 200, "spiceJet", 8));
        return flights;
    }
}
