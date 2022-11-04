import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {
    private static Map<Integer, Task> tasks = new HashMap<>();
    private static Map<Integer, Task> removedTasks = new HashMap<>();

    public static void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public static void removeTask(int id) {
        try {
            if (tasks.containsKey(id)) {
                removedTasks.put(id, tasks.get(id));
                tasks.remove(id);
            } else {
                throw new TaskNotFoundException();
            }
        } catch (TaskNotFoundException e) {
            System.out.println("Нет такого id");
        }
    }

    public static void getAllGroupedTasks() {
        Map<LocalDate, List<Task>> groupedTasks = new HashMap<>();
        List<Task> tasks1 = new ArrayList<>();
        for (Map.Entry<Integer, Task> task : tasks.entrySet()) {
            tasks1.add(task.getValue());
            groupedTasks.put(task.getValue().getDateOfTask().toLocalDate(), tasks1);
        }
        System.out.println(groupedTasks);
    }


    public static void getRemovedTasks() {
        System.out.println(removedTasks);
    }
    public static void getAllTasksInSpecifiedDay(LocalDate specifiedDay) {
        for (Map.Entry<Integer, Task> task : tasks.entrySet()) {
            if (task.getValue().appearsIn(specifiedDay)) {
                System.out.println(task);
            }

        }
    }

    public static void updateHeading(int id, String heading) {
        if (tasks.containsKey(id)) {
            tasks.get(id).setHeading(heading);
        }
    }
    public static void updateDescription(int id, String description) {
        if (tasks.containsKey(id)) {
            tasks.get(id).setDescription(description);
        }
    }
}
