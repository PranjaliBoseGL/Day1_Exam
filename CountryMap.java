import java.util.HashMap;

public class CountryMap 
{

	public static void main(String[] args) 
	{
		Country cm = new Country();

		cm.saveCountryCapital("India", "Delhi");
		cm.saveCountryCapital("Germany", "Berlin");
		cm.saveCountryCapital("Japan","Tokyo");
		cm.saveCountryCapital("England","London");

		System.out.println(cm.getCapital("India"));
		System.out.println(cm.getCountry("London"));
		System.out.println(cm.toArrayList());

		HashMap<String, String> M2 = cm.swapKyeValue();
		System.out.println(M2);
	}

}