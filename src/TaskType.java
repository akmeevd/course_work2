public enum TaskType {
    PRIVATE_TASK("личная задача"), WORKING_TASK("рабочая задача");
    private String name;

    TaskType(String name) {
        this.name = name;
    }
}
