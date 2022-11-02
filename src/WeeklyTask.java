import java.time.LocalDate;

public class WeeklyTask extends Task{
    public WeeklyTask(String heading, String description, TaskType typeOfTask) throws WrongDataOfTask {
        super(heading, description, typeOfTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return (localDate.isEqual(this.getDateOfTask().toLocalDate()) ||
                localDate.isAfter(this.getDateOfTask().toLocalDate())) && localDate.getDayOfWeek() ==
                        this.getDateOfTask().getDayOfWeek();
    }


}
