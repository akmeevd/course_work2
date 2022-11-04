import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public abstract class Task {


    private int id;
    private static int count;
    private String heading;
    private String description;
    private TaskType typeOfTask;
    private LocalDateTime dateOfTask;


    public Task(String heading, String description, TaskType typeOfTask) throws IncorrectArgumentException {
        if (heading == null || heading.isEmpty() || heading.isBlank()) {
            try {
                throw new IncorrectArgumentException("Некорректный заголовок");
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            this.heading = heading;
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            try {
                throw new IncorrectArgumentException("Некорректне описание");
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            this.description = description;
        }
        this.dateOfTask = LocalDateTime.now();
        if (typeOfTask == null) {
            try {
                throw new IncorrectArgumentException("Введите тип задачи");
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            this.typeOfTask = typeOfTask;
        }
        this.id = count;
        count++;
    }

    public abstract boolean appearsIn(LocalDate localDate);


    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public TaskType getTypeOfTask() {
        return typeOfTask;
    }

    public LocalDateTime getDateOfTask() {
        return dateOfTask;
    }

    public int getId() {
        return id;
    }



    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(heading, task.heading) && Objects.equals(description, task.description) && typeOfTask == task.typeOfTask && Objects.equals(dateOfTask, task.dateOfTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, heading, description, typeOfTask, dateOfTask);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                ", typeOfTask=" + typeOfTask +
                '}';
    }

}
