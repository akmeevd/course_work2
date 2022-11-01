import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String heading, String description, TypeOfTask typeOfTask) throws WrongDataOfTask {
        super(heading, description, typeOfTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return (localDate.isEqual(this.getDateOfTask().toLocalDate()) ||
                localDate.isAfter(this.getDateOfTask().toLocalDate())) && localDate.getDayOfMonth() ==
                        this.getDateOfTask().getDayOfMonth();
    }

    @Override
    public void getFutureTaskDate() {
        if (this.getDateOfTask().toLocalDate().isBefore(LocalDate.now()) || this.getDateOfTask().toLocalDate().isEqual(LocalDate.now())) {
            LocalDate futureTaskDate = this.getDateOfTask().toLocalDate().plusMonths(1);
            System.out.println("Следующая дата задачи - " + futureTaskDate);
        }
    }
}
