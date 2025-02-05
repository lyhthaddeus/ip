package Interface;

public interface ITask {
    public void markDone();
    public void markUndone();
    public String toString();

    public String toFileFormat();

}
