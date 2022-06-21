import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalService {
    Map<String, Branch> branches;

    public RentalService() {
        this.branches = new HashMap<>();
    }

    public boolean addBranch(String branchName, List<String> vehicles) {
        if(alreadyExists(branchName))
            return false;
        branches.put(branchName, new Branch(branchName, vehicles));
        return true;
    }

    private boolean alreadyExists(String branchName) {
        return branches.containsKey(branchName);
    }

    public boolean addVehicle(String branchName, String vehicleType, String vehicleId, int price) {
        if(!alreadyExists(branchName))
            return false;
        Branch currentBranch = branches.get(branchName);
        return currentBranch.addVehicle(vehicleType, vehicleId, price);
    }
}
