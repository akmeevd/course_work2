import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) throws WrongDataOfTask {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            System.out.println("Введите id задачи: ");
                            int id = scanner.nextInt();
                            removeTask(id);
                            break;
                        case 3:
                            getAllTasksInThisDay();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }


    private static void inputTask(Scanner scanner) throws WrongDataOfTask {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String descriptionTask = scanner.next();
        System.out.print("1. личная задача\n2. рабочая задача\nВыберите тип задачи: ");
        int typeTask = scanner.nextInt();
        System.out.print("1.однократная задача\n2.ежедневная задача\n3.еженедельная задача\n4.ежемесячная задача\n5.ежегодная задача\nВведите номер задачи: ");
        int frequencyTask = scanner.nextInt();
        Task task = new Task(taskName, descriptionTask);
        if (typeTask == 1) {
            task.setTypeOfTask(Task.TypeOfTask.privateTask);
        } else if (typeTask == 2) {
            task.setTypeOfTask(Task.TypeOfTask.WorkingTask);
        }
        if (frequencyTask == 1) {
            task.setFrequencyTask(Task.FrequencyTask.single);
        } else if (frequencyTask == 2) {
            task.setFrequencyTask(Task.FrequencyTask.daily);
        } else if (frequencyTask == 3) {
            task.setFrequencyTask(Task.FrequencyTask.weekly);
        } else if (frequencyTask == 4) {
            task.setFrequencyTask(Task.FrequencyTask.monthly);
        } else if (frequencyTask == 5) {
            task.setFrequencyTask(Task.FrequencyTask.annual);
        }
        tasks.add(task);
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Получить задачу на указанный день");
        System.out.println("0. Выход");

    }

    private static void removeTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(tasks.get(i));
            }
        }
    }

    public static void getAllTasksInThisDay() {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDateOfTask().toString().contains(LocalDate.now().toString())) {
                System.out.println(tasks.get(i));
            }
        }
    }
}

