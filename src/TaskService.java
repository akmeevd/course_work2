import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TaskService {
    private static Map<Integer, Task> tasks = new HashMap<>();
    private static Map<Integer, Task> removedTasks = new HashMap<>();

    public static void addTask(Task task) {
        tasks.put(task.getId(), task);
    }


    public static void removeTaskAndPutInArchive(int id) {
        for (Map.Entry<Integer, Task> task : tasks.entrySet()) {
            if (task.getValue().getId() == id) {
                Task removedTask = task.getValue();
                removedTasks.put(removedTask.getId(), removedTask);
            }
        }
        removeTask(id);

    }
    public static void removeTask(int id){
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        } else {
            try {
                throw new TaskNotFoundException();
            } catch (TaskNotFoundException e) {
                System.out.println("Нет такого id");
            }
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
