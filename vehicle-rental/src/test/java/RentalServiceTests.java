import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RentalServiceTests {
    RentalService rentalService;
    @BeforeEach
    void initialise() {
        rentalService = new RentalService();
    }

    @Test
    void shouldAddNewBranch() {
        assertTrue(rentalService.addBranch("b1", Arrays.stream(new String[]{"Car", "Bike", "SUV"}).toList()));
    }

    @Test
    void shouldNotAddBranchWithSameName() {
        rentalService.addBranch("b1", Arrays.stream(new String[]{"Car", "Bike", "SUV"}).toList());
        assertFalse(rentalService.addBranch("b1", Arrays.stream(new String[]{"Car", "Bike", "SUV"}).toList()));
    }

    @Test
    void shouldAddVehicle() {
        rentalService.addBranch("b1", Arrays.stream(new String[]{"Car", "Bike", "SUV"}).toList());
        assertTrue(rentalService.addVehicle("b1", "Car", "v1", 2343));
    }

    @Test
    void shouldNotAddVehicleWhenBranchDoesNotExist() {
        rentalService.addBranch("b1", Arrays.stream(new String[]{"Car", "Bike", "SUV"}).toList());
        assertFalse(rentalService.addVehicle("b2", "Car", "v1", 2343));
    }
}
