import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public abstract class Task {

    public enum TypeOfTask {
        privateTask("личная задача"), WorkingTask("рабочая задача");
        private String name;

        TypeOfTask(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TypeOfTask{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private int id;
    private static int count;
    private String heading;
    private String description;
    private TypeOfTask typeOfTask;
    private LocalDateTime dateOfTask;


    public Task(String heading, String description, TypeOfTask typeOfTask) throws WrongDataOfTask {
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
        this.dateOfTask = LocalDateTime.now();
        if (typeOfTask == null) {
            throw new WrongDataOfTask("Введите тип задачи");
        } else {
            this.typeOfTask = typeOfTask;
        }
        this.id = count;
        count++;
    }

    public abstract boolean appearsIn(LocalDate localDate);

    public abstract void getFutureTaskDate();

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
