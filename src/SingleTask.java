import java.time.LocalDate;

public class SingleTask extends Task{
    public SingleTask(String heading, String description, TypeOfTask typeOfTask) throws WrongDataOfTask {
        super(heading, description, typeOfTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return false;
    }

    @Override
    public void getFutureTaskDate() {
        System.out.println("Задача однократная!");

    }
}
