package uk.co.codeecho.tvjackal.desktop;

import javafx.stage.Stage;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uk.co.codeecho.mandrake.core.router.Router;

public class Application extends uk.co.codeecho.mandrake.desktop.Application {

    @Override
    protected Router setup(Stage stage) {
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_desktop.xml");
            Router router = applicationContext.getBean(Router.class);
            return router;
        } catch (Throwable ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
