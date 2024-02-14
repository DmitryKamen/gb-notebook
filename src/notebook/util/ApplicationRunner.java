package notebook.util;

import static notebook.util.DBConnector.createDB;

import java.util.ArrayList;
import java.util.List;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.model.repository.GBRepository;
import notebook.model.repository.impl.UserRepository;
import notebook.view.UserView;

public class ApplicationRunner {
    public static final List<User> HASH = new ArrayList<>();

    private ApplicationRunner(){
        createDB();
        GBRepository repository = new UserRepository();
        UserController controller = new UserController(repository);
        HASH.addAll(controller.readAll());
        UserView view = new UserView(controller);
        view.run();
    }

    public static void run(){
        new ApplicationRunner();
    }
}
