import java.util.Date;

public abstract class Employee {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String email;
    public Date joiningDate;

    public Employee(int id, String name, Date dateOfBirth, String email, Date joiningDate) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public abstract Leave calculateLeave();

    protected abstract double getTotalVacationLeave();

    protected abstract double getTotalSickLeave();

    @Override
    public String toString() {
        return "Employee ID: " + id +
                "\nName: " + name +
                "\nDate of Birth: " + dateOfBirth +
                "\nEmail: " + email +
                "\nJoining Date: " + joiningDate;
    }
}
