package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.AddDamageRecord;
import java.util.Date;
import models.Car;
import models.CarParks;
import models.Staff;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for AddDamageRecord command
 * @author Wing
 */
public class AddDamageRecordIT {
    
    private String vehicleId = "CAR001";
    private String brand = "Honda";
    private String model = "GT86";
    private int seats = 4;
    private CarParks loc = CarParks.CarPark01;
    private String desc = "Test for vehicle related commands";

    private Car vehicle = new Car(vehicleId, brand, model, seats, loc, desc);

    private String staffId = "Staff001";
    private String fName = "Wing";
    private String lName = "Chau";
    private String addr = "Somewhere in Plymouth";
    private String licenseNum = "LN001";
    private String licenseType = "Manual";

    private Staff staff = new Staff(staffId, fName, lName, addr, licenseNum,
            licenseType);

   private Date damageDate = new Date();
   private String recordDesc = "Testing add damage record command";

   private ICommandBehavior addDamageRecordBehavior = 
           new AddDamageRecord(vehicle, damageDate, staff, recordDesc);
   private Command addDamageRecord = new Command(addDamageRecordBehavior);

   @Before
   public void setUp() {
       System.out.println("Testing AddDamageRecord command");
   }

   @Test
   public void execute() {
       boolean result;

       try {
           result = addDamageRecord.executeCommand();
           assertTrue(result);
       } catch (Exception ex) {
           System.out.println(ex.getMessage());
           fail("Exception caught");
       }
   }

   @Test
   public void undo() {
       boolean result;

       try {
           result = addDamageRecord.undoCommand();
           assertTrue(result);
       } catch (Exception ex) {
           System.out.println(ex.getMessage());
           fail("Exception caught");
       }
   }
}