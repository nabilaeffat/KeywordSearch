import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KSApplication extends Application {
	
	@Override
	public void start(Stage stage)throws Exception{
		
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(view, model);
		//AdditionControllerLoad controllerLoad = new AdditionControllerLoad(view, model);

		Scene scene = new Scene(view.asParent(), 700, 500);
		
		stage.setScene(scene);
		stage.setTitle("MVC-Application");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
