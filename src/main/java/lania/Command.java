package lania;

import lania.task.TaskList;

public abstract class Command {

    protected boolean isExit;

    public boolean isExit() {
        return this.isExit;
    }

    public abstract void execute(TaskList tasks, Storage storage, Ui ui);
}
