import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Task implements Frequency {


    @Override
    public void dailyTask() {
        if (this.frequencyTask.equals(FrequencyTask.daily) && this.getDateOfTask().isAfter(LocalDateTime.now())) {
            this.setDateOfTask(getDateOfTask().plusDays(1));
        }
        System.out.println(this.getDateOfTask().plusDays(1));
    }

    @Override
    public void weeklyTask() {
        if (this.frequencyTask.equals(FrequencyTask.weekly) && this.getDateOfTask().isAfter(LocalDateTime.now())) {
            this.setDateOfTask(getDateOfTask().plusWeeks(1));
        }
        System.out.println(this.getDateOfTask().plusWeeks(1));
    }

    @Override
    public void monthlyTask() {
        if (this.frequencyTask.equals(FrequencyTask.monthly) && this.getDateOfTask().isAfter(LocalDateTime.now())) {
            this.setDateOfTask(getDateOfTask().plusMonths(1));
        }
        System.out.println(this.getDateOfTask().plusMonths(1));
    }

    @Override
    public void annualTask() {
        if (this.frequencyTask.equals(FrequencyTask.annual) && this.getDateOfTask().isAfter(LocalDateTime.now())) {
            this.setDateOfTask(getDateOfTask().plusYears(1));
        }
        System.out.println(this.getDateOfTask().plusYears(1));
    }

    public enum TypeOfTask {
        privateTask, WorkingTask;
    }

    public enum FrequencyTask {
        single, daily, weekly, monthly, annual;
    }

    private int id;
    private static int count;
    private String heading;
    private String description;
    private TypeOfTask typeOfTask;
    private LocalDateTime dateOfTask = LocalDateTime.now();
    private FrequencyTask frequencyTask;

    public Task(String heading, String description) throws WrongDataOfTask {
        if (heading == null || heading.isEmpty() || heading.isBlank()) {
            throw new WrongDataOfTask("Некорректный заголовок");
        } else {
            this.heading = heading;
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new WrongDataOfTask("Некорректне описание");
        } else {
            this.description = description;
        }
        this.id = count;
        count++;
    }

    public Task(String heading) throws WrongDataOfTask {
        if (heading == null || heading.isEmpty() || heading.isBlank()) {
            throw new WrongDataOfTask("Некорректный заголовок");
        } else {
            this.heading = heading;
        }
        this.id = count;
        count++;
    }


    public Task(String heading, String description, TypeOfTask typeOfTask, FrequencyTask frequencyTask) throws WrongDataOfTask {
        if (heading == null || heading.isEmpty() || heading.isBlank()) {
            throw new WrongDataOfTask("Некорректный заголовок");
        } else {
            this.heading = heading;
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new WrongDataOfTask("Некорректне описание");
        } else {
            this.description = description;
        }
        this.typeOfTask = typeOfTask;
        this.frequencyTask = frequencyTask;
        this.id = count;
        count++;
    }



    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }

    public LocalDateTime getDateOfTask() {
        return dateOfTask;
    }

    public int getId() {
        return id;
    }

    public FrequencyTask getFrequencyTask() {
        return frequencyTask;
    }

    public void setFrequencyTask(FrequencyTask frequencyTask) {
        this.frequencyTask = frequencyTask;
    }

    public void setTypeOfTask(TypeOfTask typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    private void setDateOfTask(LocalDateTime dateOfTask) {
        this.dateOfTask = dateOfTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(heading, task.heading) && Objects.equals(description, task.description) && typeOfTask == task.typeOfTask && Objects.equals(dateOfTask, task.dateOfTask) && frequencyTask == task.frequencyTask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, heading, description, typeOfTask, dateOfTask, frequencyTask);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                ", typeOfTask=" + typeOfTask +
                ", frequencyTask=" + frequencyTask +
                '}';
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime2 = LocalDateTime.now();
        localDateTime2.toString().contains(localDateTime.toString().substring(0, 10));
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.toString().contains(localDateTime.toString().substring(0, 10)));
    }
}
