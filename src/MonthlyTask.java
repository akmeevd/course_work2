import java.time.LocalDate;

public class MonthlyTask extends Task{
    public MonthlyTask(String heading, String description, TaskType typeOfTask) throws IncorrectArgumentException {
        super(heading, description, typeOfTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return (localDate.isEqual(this.getDateOfTask().toLocalDate()) ||
                localDate.isAfter(this.getDateOfTask().toLocalDate())) && localDate.getDayOfMonth() ==
                        this.getDateOfTask().getDayOfMonth();
    }


}
