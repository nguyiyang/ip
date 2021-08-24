package lania;

import lania.Task;

public class Todo extends Task {

    /**
     * Constructor for lania.Todo. Takes in a String description.
     * Initialises description of the todo.
     *
     * @param description The name of the todo.
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
