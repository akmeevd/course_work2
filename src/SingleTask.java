import java.time.LocalDate;

public class SingleTask extends Task{
    public SingleTask(String heading, String description, TaskType typeOfTask) throws WrongDataOfTask {
        super(heading, description, typeOfTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.isEqual(this.getDateOfTask().toLocalDate());
    }


}
