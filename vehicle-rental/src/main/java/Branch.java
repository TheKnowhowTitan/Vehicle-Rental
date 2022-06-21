import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {
    private String branchName;
    private List<String> vehicleTypes;
    private Map<String, Vehicle> vehicles;

    public Branch(String branchName, List<String> vehicles) {
        this.branchName = branchName;
        this.vehicleTypes = vehicles;
        this.vehicles = new HashMap<>();
    }

    public boolean addVehicle(String vehicleType, String vehicleId, int price) {
        if(!vehicleTypePresent(vehicleType))
            return false;
        if(vehicleIdPresent(vehicleId))
            return false;
        Vehicle newVehicle = new Vehicle(vehicleType, vehicleId, price);
        vehicles.put(vehicleId, newVehicle);
        return true;
    }

    private boolean vehicleIdPresent(String vehicleId) {
        return vehicles.containsKey(vehicleId);
    }

    private boolean vehicleTypePresent(String vehicleType) {
        return vehicleTypes.contains(vehicleType);
    }
}
