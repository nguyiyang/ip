package lania.command;

import java.io.IOException;

import lania.Storage;
import lania.Ui;
import lania.task.Task;
import lania.task.TaskList;

/**
 * The command representing the scenario where the user
 * wants to delete a task.
 */
public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Deletes the given task to the list of tasks, saves the resulting
     * list of tasks into hard drive and displays corresponding message.
     *
     * @param tasks The user's list of tasks.
     * @param storage The object dealing with loading and storing of tasks.
     * @param ui The object dealing with user interactions.
     * @return The message displayed by executing the delete command.
     */
    @Override
    public String execute(TaskList tasks, Storage storage, Ui ui) {
        Task deletedTask = tasks.remove(index);
        String message = ui.showRemoveMessage(tasks, deletedTask);
        try {
            storage.save(tasks);
        } catch (IOException e) {
            ui.showError();
        }
        return message;
    }
}
