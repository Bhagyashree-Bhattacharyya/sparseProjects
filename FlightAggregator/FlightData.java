package games.FlightAggregator;

import java.util.Date;

public class FlightData {
    private String src;
    private String dest;
    private Date jDate;
    private double cost;
    private String type;
    private int id;

    public FlightData(String src, String dest, Date jDate, double cost, String type, int id) {
        this.src = src;
        this.dest = dest;
        this.jDate = jDate;
        this.cost = cost;
        this.type = type;
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Date getjDate() {
        return jDate;
    }

    public void setjDate(Date jDate) {
        this.jDate = jDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "src='" + src + '\'' +
                ", dest='" + dest + '\'' +
                ", jDate=" + jDate +
                ", cost=" + cost +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}
