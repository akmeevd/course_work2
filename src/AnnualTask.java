import java.time.LocalDate;

public class AnnualTask extends Task {
    public AnnualTask(String heading, String description, TaskType typeOfTask) throws WrongDataOfTask {
        super(heading, description, typeOfTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return (localDate.isEqual(this.getDateOfTask().toLocalDate()) ||
                localDate.isAfter(this.getDateOfTask().toLocalDate())) && localDate.getDayOfYear() ==
                        this.getDateOfTask().getDayOfYear();
    }


}
