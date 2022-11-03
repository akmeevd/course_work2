import java.time.LocalDate;

public class DailyTask extends Task {
    public DailyTask(String heading, String description, TaskType typeOfTask) throws IncorrectArgumentException {
        super(heading, description, typeOfTask);
    }


    @Override
    public boolean appearsIn(LocalDate localDate) {
        return (localDate.isEqual(this.getDateOfTask().toLocalDate()) ||
                localDate.isAfter(this.getDateOfTask().toLocalDate()));

    }

}
