import controller.AdapterController;
import controller.Controller;
import loggers.Logger;
import loggers.LoggerImpl;
import model.*;
import views.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = new LoggerImpl("logger.txt");
        FileOperation fileOperation = new FileOperationImpl("notes.txt");
        Repository repository = new RepositoryImpl(new NotesMapperJSON(), fileOperation);
        Controller controller = new AdapterController(repository);
        ViewOperations viewOperations = new ViewOperationsImpl(controller);
        ViewOperations viewOperationsWithLog = new ViewOperationWithLog(viewOperations, logger);
        ViewNote view = new ViewNoteImpl(viewOperationsWithLog);
        view.run();
    }
}