import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IncorrectArgumentException   {
        Task task = new DailyTask("Поход в магазин", "сходить в магазин за необходимыми продуктами", TaskType.PRIVATE_TASK);
        Task task1 = new WeeklyTask("уборка", "прибраться дома", TaskType.PRIVATE_TASK);
        Task task2 = new MonthlyTask("Оплата ЖКХ", "оплатить за дом", TaskType.PRIVATE_TASK);
        Task task3 = new AnnualTask("Набор баллов НМО", "набрать 50 баллов ЗЕТ на работе за год", TaskType.WORKING_TASK);
        Task task4 = new SingleTask("Тренировка", "позаниматься спортом", TaskType.PRIVATE_TASK);
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
                            System.out.print("Введите id задачи: ");
                            int id = scanner.nextInt();
                            TaskService.removeTask(id);
                            break;
                        case 3:
                            System.out.print("Введите дату, чтоб узнать задачи на этот день:");
                            LocalDate specifiedDay = LocalDate.parse(scanner.next());
                            TaskService.getAllTasksInSpecifiedDay(specifiedDay);
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


    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
    }
    private static void printMenu() {
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Получить задачу на указанный день");
        System.out.println("0. Выход");

    }

}

