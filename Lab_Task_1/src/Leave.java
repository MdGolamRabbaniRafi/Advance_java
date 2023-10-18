public class Leave {
    private int vacationLeave;
    private int sickLeave;

    public Leave(int vacationLeave, int sickLeave) {
        this.vacationLeave = vacationLeave;
        this.sickLeave = sickLeave;
    }

    public int getVacationLeave() {
        return vacationLeave;
    }

    public int getSickLeave() {
        return sickLeave;
    }
}
