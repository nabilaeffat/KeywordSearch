

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class View {
	
	private GridPane view;
	private Button btnSource;
	private Label lblSource;
	private Button btnload ;
	private TextArea txtArea;
	
	private Label lblSearch;
	private Button btnSearch;
	private TextField txtSearch;
	
	private Button btnPieChart;
	private Button btnBarChart;

	
	//A radio button with an empty string for its label
	private RadioButton rbTop3;
	private RadioButton rbTop5;
	private RadioButton rbTop8;
	private RadioButton rbTop10;

	final ToggleGroup group = new ToggleGroup();

	
	public View() {
		createAndConfigurePane();
		createAndLayoutControls();
	}
	
	public Parent asParent() {
		return view;
	}
	
	private void createAndLayoutControls() {
		
		btnSource = new Button("Choose Source");
		lblSource = new Label("");
		btnload = new Button("Load");
		txtArea = new TextArea();
		
		lblSearch = new Label("Search Keyword");
	    btnSearch = new Button("Search"); 
	    txtSearch = new TextField();
	    
	    rbTop3 = new RadioButton("Top-3 Correlated Keywards");
	    rbTop3.setToggleGroup(group);
	    rbTop3.setSelected(true);
	    
	    rbTop5 = new RadioButton("Top-8 Correlated Keywards");
	    rbTop5.setToggleGroup(group);

	    rbTop8 = new RadioButton("Top-10 Correlated Keywards");
	    rbTop8.setToggleGroup(group);

	    rbTop10 = new RadioButton("Top-10 Correlated Keywards");
	    rbTop10.setToggleGroup(group);
	    
	    btnBarChart = new Button("Bar Chart");
	    btnPieChart = new Button("Pie Chart");
		
		view.addRow(0,new Label("Load XML file"), btnSource,btnload, lblSource);
		view.addRow(1, lblSearch,txtSearch, btnSearch);

		
		view.add(txtArea, 1, 2, 4, 2);//(colIndex,rowIndex,spanning 2 col, row2)
		view.addRow( 4, new Label("Data Visualization"));

		view.addRow( 5, rbTop3,rbTop5);
		view.addRow( 6, rbTop8,rbTop10);
		view.addRow( 7, btnPieChart,btnBarChart);

	}
	
	private void createAndConfigurePane() {
		view = new GridPane();
		view.setAlignment(Pos.CENTER);
		view.setHgap(5);
		view.setVgap(10);
		view.setPrefWidth(40);
		
	} 	
	
		
	public void setSourceLabel(String fileName) {
		lblSource.setText(fileName);
	}
		
	public String getlblSourceField() {
		return lblSource.getText();
	}
	
	public void setTextArean(String xmlList) {
		txtArea.setText(xmlList);
	}
	
	public String gettxtSearchField() {
		return txtSearch.getText();
	}
	
	public void addChooseFileListener(EventHandler<ActionEvent> listener) {
		btnSource.setOnAction(listener);
	}
		
	public void addLoadFileListener(EventHandler<ActionEvent> listener) {
		btnload.setOnAction(listener);
	}
	
	public void addSearchListener(EventHandler<ActionEvent> listener) {
		btnSearch.setOnAction(listener);
	}
}
