import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String heading, String description, TypeOfTask typeOfTask) throws WrongDataOfTask {
        super(heading, description, typeOfTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return (localDate.isEqual(this.getDateOfTask().toLocalDate()) ||
                localDate.isAfter(this.getDateOfTask().toLocalDate())) && localDate.getDayOfWeek() ==
                        this.getDateOfTask().getDayOfWeek();
    }

    @Override
    public void getFutureTaskDate() {
        if (this.getDateOfTask().toLocalDate().isBefore(LocalDate.now()) || this.getDateOfTask().toLocalDate().isEqual(LocalDate.now())) {
            LocalDate futureTaskDate = this.getDateOfTask().toLocalDate().plusWeeks(1);
            System.out.println("Следующая дата задачи - " + futureTaskDate);
        }
    }
}
