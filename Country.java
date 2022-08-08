import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Country 
{
	private HashMap<String, String> M1;

	public Country() 
	{
		M1 = new HashMap<String, String>();
	}
	
	
	//1
	public HashMap<String, String> saveCountryCapital(String Countryname, String capitalname) 
	{
		M1.put(Countryname, capitalname);
		return M1;
	}

	//2
	public String getCapital(String Countryname) 
	{
		System.out.println("CAPITAL IS : ");
		return M1.get(Countryname);
	}
	
	
	//3
	public String getCountry(String capitalname)
	{
		Set<Entry<String, String>> set = M1.entrySet();
		Iterator<Entry<String, String>> i = set.iterator();

		while (i.hasNext()) 
		{
			Map.Entry<String, String> m = i.next();

			if (m.getValue().equals(capitalname))
			{
				System.out.println("COUNTRY IS : ");
				return m.getKey();
			}				
		}

		return null;
	}

	
	//4
	public HashMap<String, String> swapKyeValue() 
	{
		HashMap<String, String> M2 = new HashMap<String, String>();

		Set<Entry<String, String>> set = M1.entrySet();
		Iterator<Entry<String, String>> i = set.iterator();

		while (i.hasNext()) 
		{
			Map.Entry<String, String> m = i.next();
			M2.put(m.getValue(), m.getKey());
		}

		return M2;
	}

	
	//5
	public ArrayList<String> toArrayList() 
	{
		ArrayList<String> list = new ArrayList<>();

		Set<Entry<String, String>> set = M1.entrySet();
		Iterator<Entry<String, String>> i = set.iterator();

		while (i.hasNext())
		{
			Map.Entry<String, String> m = i.next();
			list.add(m.getKey());
		}

		return list;
	}
}

