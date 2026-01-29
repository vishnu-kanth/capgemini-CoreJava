package PracticeQuestionsMentor;
import java.util.*;

class DataCenter {
    private String dataCenterId;
    private String location;
    private String supervisorName;
    private double coolingPowerUsage;

    public DataCenter() {}

    public DataCenter(String dataCenterId, String location, String supervisorName, double coolingPowerUsage) {
        this.dataCenterId = dataCenterId;
        this.location = location;
        this.supervisorName = supervisorName;
        this.coolingPowerUsage = coolingPowerUsage;
    }

    public String getDataCenterId() {
        return dataCenterId;
    }

    public String getLocation() {
        return location;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public double getCoolingPowerUsage() {
        return coolingPowerUsage;
    }
}

class DataCenterUtil {

    private Set<DataCenter> dataCenterSet = new LinkedHashSet<>();

    public void addDataCenter(DataCenter dataCenter) {
        dataCenterSet.add(dataCenter);
    }

    public DataCenter getDataCenterById(String dataCenterId) {
        for (DataCenter dc : dataCenterSet) {
            if (dc.getDataCenterId().equals(dataCenterId))
                return dc;
        }
        return null;
    }

    public List<DataCenter> getDataCentersWithMaximumCoolingPowerUsage() {

        double max = 0;
        for (DataCenter dc : dataCenterSet) {
            if (dc.getCoolingPowerUsage() > max)
                max = dc.getCoolingPowerUsage();
        }

        List<DataCenter> result = new ArrayList<>();
        for (DataCenter dc : dataCenterSet) {
            if (dc.getCoolingPowerUsage() == max)
                result.add(dc);
        }
        return result;
    }
}

public class DataCenterInterface {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DataCenterUtil util = new DataCenterUtil();

        System.out.println("Enter the number of data centers to be added");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Enter data center details");
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(":");

            DataCenter dc = new DataCenter(
                    data[0],
                    data[1],
                    data[2],
                    Double.parseDouble(data[3])
            );
            util.addDataCenter(dc);
        }

        System.out.println("Enter the Data Center ID to get details");
        String id = sc.nextLine().trim();

        DataCenter found = util.getDataCenterById(id);
        if (found != null) {
            System.out.println(found.getDataCenterId() + " | " +
                    found.getLocation() + " | " +
                    found.getSupervisorName() + " | " +
                    found.getCoolingPowerUsage());
        } else {
            System.out.println("Data Center not found for the ID " + id);
        }

        System.out.println("Data Centers with maximum cooling power usage");
        for (DataCenter dc : util.getDataCentersWithMaximumCoolingPowerUsage()) {
            System.out.println(dc.getDataCenterId() + " | " +
                    dc.getLocation() + " | " +
                    dc.getSupervisorName() + " | " +
                    dc.getCoolingPowerUsage());
        }

        sc.close();
    }
}
