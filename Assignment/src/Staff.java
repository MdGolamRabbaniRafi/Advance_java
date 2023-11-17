import java.util.Date;
import java.util.Calendar;

@LeapYear
public class Staff extends Employee {
    public Staff(int id, String name, Date dateOfBirth, String email, Date joiningDate) {
        super(id, name, dateOfBirth, email, joiningDate);
    }

    @Override
    public Leave calculateLeave() {
        double totalVacationLeave = getTotalVacationLeave();
        double totalSickLeave = getTotalSickLeave();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(joiningDate);
        double joiningDay = calendar.get(Calendar.DAY_OF_YEAR);

        double daysInYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);

        double vacationLeave = ((daysInYear - joiningDay + 1) * totalVacationLeave) / daysInYear;
        double sickLeave = ((daysInYear - joiningDay + 1) * totalSickLeave) / daysInYear;

        // Round to the nearest integer
        vacationLeave = Math.round(vacationLeave);
        sickLeave = Math.round(sickLeave);

        return new Leave((int) vacationLeave, (int) sickLeave);
    }



    @Override
    protected double getTotalVacationLeave() {
        return 10;
    }

    @Override
    protected double getTotalSickLeave() {
        return 7;
    }
}