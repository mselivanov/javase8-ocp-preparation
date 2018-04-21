import java.util.*;

public class Zoo {
	public static void main(String[] args){
		Locale us = new Locale("en", "US");
		Locale france = new Locale("fr", "FR");
		System.out.println("----- US properties -----");
		printProperties(us, "Zoo");
		System.out.println("----- France properties -----");
		printProperties(france, "Zoo");
		printProperties(us, "resourcebundles.Zoo");

	}

	public static void printProperties(Locale l, String bundleName){
		ResourceBundle rb = ResourceBundle.getBundle(bundleName, l);
		Set<String> keys = rb.keySet();
		keys.stream()
			.map(k -> String.format("Key: %s Value: %s", k, rb.getObject(k)))
			.forEach(System.out::println);

	}
}
