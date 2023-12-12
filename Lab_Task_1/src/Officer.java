import java.util.Date;
import java.util.Calendar;

@LeapYear
public class Officer extends Employee {
    public Officer(int id, String name, Date dateOfBirth, String email, Date joiningDate) {
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
        System.out.println("Before Rounded "+vacationLeave);
        System.out.println("Before Rounded "+sickLeave);

        vacationLeave = Math.round(vacationLeave);
        sickLeave = Math.round(sickLeave);
        System.out.println("Rounded "+vacationLeave);
        System.out.println("Rounded "+sickLeave);


        return new Leave((int) vacationLeave, (int) sickLeave);
    }




    @Override
    protected double getTotalVacationLeave() {
        return 15;
    }

    @Override
    protected double getTotalSickLeave() {
        return 10;
    }
}
