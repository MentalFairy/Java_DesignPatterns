package models;

import java.io.Serializable;
import java.util.Date;

/**
 * A class to hold records of Cars being allocated to Staff.
 * 
 * @author Wing
 */
public class AllocationRecord implements Serializable {

    private final Car car;
    private final Staff staff;
    
    private final boolean longTermAllocation;
    private final Date startDate, endDate;

    
    /**
     * Empty Constructor, Exists for compatibility purposes.
     * Should not be used.
     */
    public AllocationRecord()
    {
        car = null;
        staff = null;
        
        longTermAllocation = false;
        startDate = null;
        endDate = null;
    }
    
    /**
     * Constructor, creates an Allocation Record and attaches it to the relevant objects.
     * 
     * @param _car Car.
     * @param _staff Employee vehicle is allocated to.
     * @param _startDate Start of allocation.
     */
    public AllocationRecord(Car _car, Staff _staff, Date _startDate) {
        car = _car;
        staff = _staff;
        startDate = _startDate;
        endDate = null;

        longTermAllocation = false;
        _car.addAllocationRecord(this);
        _staff.addAllocationRecord(this);
    }

    /**
     * Constructor, creates an Allocation Record and attaches it to the relevant objects.
     *
     * @param _car Car.
     * @param _staff Employee vehicle is allocated to.
     * @param _startDate Start of allocation.
     * @param _endDate End of allocation.
     */
    public AllocationRecord(Car _car, Staff _staff, Date _startDate, 
            Date _endDate) {
        car = _car;
        staff = _staff;
        startDate = _startDate;
        endDate = _endDate;

        longTermAllocation = true;
        _car.addAllocationRecord(this);
        _staff.addAllocationRecord(this);
    }
    
    /**
     * Delete the allocation record.
     */
    public void Delete()
    {
        car.removeAllocationRecord(this);
        staff.removeAllocationRecord(this);
    }
    
    /**
     * Returns the Car this record relates to.
     * 
     * @return Car
     */
    public Car getCar() {
        return car;
    }

    /**
     * Returns the Staff member this record relates to.
     * 
     * @return Staff
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     * Is this a long term allocation?
     * 
     * @return boolean
     */
    public boolean getLongTermAllocation() {
        return longTermAllocation;
    }

    /**
     * Return the start date of the allocation.
     *
     * @return Calendar
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Return the end date of the allocation.
     *
     * @return Calendar
     * @throws NullPointerException No end date specified.
     */
    public Date getEndDate() throws NullPointerException {
        if (endDate == null)
            throw new NullPointerException();
        return endDate;
    }
    
    /**
     * String representation of object.
     *
     * @return String
     */
    public String toString()
    {
        if (endDate != null)
            return car.getCARID() + " Assigned to " + staff.getSTAFFID() + " from " + startDate + " to " + endDate;
        else
            return car.getCARID() + " Assigned to " + staff.getSTAFFID() + " on " + startDate;
    }
}
