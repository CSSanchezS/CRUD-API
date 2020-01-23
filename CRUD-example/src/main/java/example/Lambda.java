package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game  football = new Game() {
			public void play() {
				System.out.println("I'm Playing Football");
			}
		};
		
		football.play();
		
		Game  basquetball = new Game() {
			public void play() {
				System.out.println("I'm Playing Basquetball");
			}
		};
		
		 basquetball.play();
		 
		Game footballLambda = () ->
				System.out.println("I'm Playing Football");
		
				footballLambda.play();
				
		Series netflixSeries = (type) ->
				System.out.println("Netflix Series from type: "+ type);
				
				netflixSeries.play("accion");
		
		//Commun way to do 
			List<String> cars = Arrays.asList(
					"Jetta","Sentra","Maxima","Altima","Leon","Versa","Mazda 3"
					);
			for (String car : cars) {
				if(car.equals("Jetta")) {
					System.err.println("yes, this car is stored here");
				}
			}
		//using lambas with streams
			cars.stream()
				.filter(car2 -> car2.equals("Jetta"))
				.forEach(car2 -> System.out.println("yes, this car is stored here"));;
				
		 Optional<String> optional = cars.stream()
				.filter(car2 -> car2.equals("Jetta"))
				.findFirst();
		 if(optional.isPresent()) {
			 System.out.println("yes  ");
		 }
		 
		 //take 0 from a string
		 String ndc = "00000-122-25";
		  String cadenaResultadoString = ndc.replaceFirst ("^0*", "");
		  System.out.println("String without 0 :" + cadenaResultadoString);
		
	}
	
	interface Game{
		void play();
	}
	
	interface Series{
		void play(String type);
	}

}
