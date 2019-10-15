import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Model {
	MovieList movies;
	
	int totalCount = 0;

	public int sum(int firstNumber, int secondNumber) {
		
		return firstNumber + secondNumber;
	}

	public boolean xmlReader(String fileName) {
		
		boolean isLoaded = false;
	
		
		try {
			
			//File inputFile = new File("MoviesData.xml");
			File inputFile = new File(fileName);
			movies = new MovieList();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();// configure document builder

			Document doc = dBuilder.parse(inputFile);// parse the input XML file
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("movie");// retrieve the elements with supercars tag


			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElement = (Element) nNode;
					String id = eElement.getAttribute("id");
					String title = eElement.getElementsByTagName("title").item(0).getTextContent();
					String dir = eElement.getElementsByTagName("director").item(0).getTextContent();
					String year = eElement.getElementsByTagName("year").item(0).getTextContent();
					String rating = eElement.getElementsByTagName("rating").item(0).getTextContent();
				
					NodeList genreNameList = eElement.getElementsByTagName("genre");
					ArrayList <String> genArrayList = new ArrayList<String>();


					for (int count = 0; count < genreNameList.getLength(); count++) {
						Node node1 = genreNameList.item(count); // retrieve a car element

						if (node1.getNodeType() == node1.ELEMENT_NODE) {
							Element genre = (Element) node1;
							String gen = genre.getTextContent();
							genArrayList.add(gen);

						}
					}

					movies.getMovieList().add(new Movie(id, title, dir, year, genArrayList, rating));
					isLoaded = true;

				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return isLoaded;
	}
	
	public String showData(String fileName) {
		String returnText = "";
		if(xmlReader(fileName)) {

			for (int i = 0 ; i< movies.getMovieList().size(); i ++) {
				
				returnText = returnText.concat(movies.getMovieList().get(i).toString()+"\n");
			}
			
			
		}
		
		return returnText;

		
	}
	
	public String searchTitle(String keyword) {
		
		String returnValue = "";		
		for(int i=0;i<this.movies.getMovieList().size();i++){
	        if(movies.getMovieList().get(i).toString().contains(keyword)){
	        	returnValue = returnValue.concat(movies.getMovieList().get(i).toString()+"\n");
	        	totalCount = i+1;
	        }
	}
		return returnValue;
	}
	
}
