
import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class Controller {
	
	private View view;
	private Model model;
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		//this.view.getBtnCalculate().setOnAction(new CalculateListener());
		
		this.view.addChooseFileListener(e -> {
			FileChooser fil_chooser = new FileChooser();
			
			
			// get the file selected 
            File file = fil_chooser.showOpenDialog(null); 

            if (file != null) { 
                  
            	this.view.setSourceLabel(file.getName()); 
            } 
			
		});
		
		this.view.addLoadFileListener(e -> {
			
			this.view.setTextArean("");
			String fileName = this.view.getlblSourceField();
			if (!fileName.isEmpty()) {
				String text = this.model.showData(fileName);
				this.view.setTextArean(text);
			}
			
		});	
		
		this.view.addSearchListener(e -> {
			this.view.setTextArean("");
			String keyword = this.view.gettxtSearchField();
			String text = this.model.searchTitle(keyword);
			this.view.setTextArean(text);
		});	
	}
	


}
