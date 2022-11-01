import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;

public class AnnualTask extends Task {
    public AnnualTask(String heading, String description, TypeOfTask typeOfTask) throws WrongDataOfTask {
        super(heading, description, typeOfTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return (localDate.isEqual(this.getDateOfTask().toLocalDate()) ||
                localDate.isAfter(this.getDateOfTask().toLocalDate())) && localDate.getDayOfYear() ==
                        this.getDateOfTask().getDayOfYear();
    }

    @Override
    public void getFutureTaskDate() {
        if (this.getDateOfTask().toLocalDate().isBefore(LocalDate.now()) || this.getDateOfTask().toLocalDate().isEqual(LocalDate.now())) {
            LocalDate futureTaskDate = this.getDateOfTask().toLocalDate().plusYears(1);
            System.out.println("Следующая дата задачи - " + futureTaskDate);
        }
    }
}
