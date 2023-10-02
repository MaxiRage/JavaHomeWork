import controllers.UserController;
import model.FileOperation;
import model.FileOperationImpl;
import repository.Repository;
import repository.RepositoryFile;
import utils.Validate;
import views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("lookupUsers.txt");
        Repository repository = new RepositoryFile(fileOperation);
        Validate validate = new Validate();
        UserController controller = new UserController(repository, validate);
        ViewUser view = new ViewUser(controller, validate);

        view.run();
    }
}
