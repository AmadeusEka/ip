public class DeleteCommand extends Command {
    private final String indexString;

    public DeleteCommand(String indexString) {
        this.indexString = indexString;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws SageException {
        int index;
        try {
            index = Integer.parseInt(indexString.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new SageException("Invalid delete command. Index must be a number.");
        }
        Task deletedTask = tasks.delete(index);
        ui.showDeletedTask(deletedTask, tasks.size());
    }
}