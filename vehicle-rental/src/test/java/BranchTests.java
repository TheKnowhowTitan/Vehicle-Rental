import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BranchTests {

    Branch branch;
    @BeforeEach
    void initialize() {
        List<String> vehicleTypes = new ArrayList<>();
        vehicleTypes.add("Car");
        branch = new Branch("b1", vehicleTypes);
    }

    @Test
    void shouldNotAddVehicleIfTypeNotPresent() {
        assertFalse(branch.addVehicle("Bus", "v1", 560));
    }

    @Test
    void shouldNotAddVehicleIfVehicleIdIsAlreadyPresent() {
        branch.addVehicle("Car", "v1", 600);
        assertFalse(branch.addVehicle("Car", "v1", 544));
    }

    @Test
    void shouldAddANewVehicle() {
        assertTrue(branch.addVehicle("Car", "v22", 433));
    }
}
