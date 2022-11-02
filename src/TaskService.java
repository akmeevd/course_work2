import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TaskService {
    private static Map<Integer, Task> tasks = new HashMap<>();

    public static void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public static void removeTask(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        } else {
            throw new RuntimeException("Такого id нет");
        }
    }
    public static void getAllTasksInSpecifiedDay(LocalDate specifiedDay) {
        for (Map.Entry<Integer, Task> task : tasks.entrySet()) {
            if (task.getValue().appearsIn(specifiedDay)) {
                System.out.println(task);
            }

        }
    }



}
