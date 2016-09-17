package es.uem.aju.common.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

import es.uem.aju.common.dto.CompanyDTO;

public class JSONObjectParserTest {

	private Gson gson;
	
	@Test
	public void permormTests(){
		testObjectToJSON();
		testJSONToObject();
	}
	
	private String testObjectToJSON(){
		gson = new Gson();			
		List<CompanyDTO> companies = new ArrayList<CompanyDTO>();
		companies.add(new CompanyDTO(0, "name0", 0));
		companies.add(new CompanyDTO(1, "name1", 1));
		CompaniesList companiesList = new CompaniesList();
		companiesList.companies = companies;
		return gson.toJson(companiesList);
		
	}
	
	private void testJSONToObject(){				
						
		String jsonStr = testObjectToJSON();
		CompaniesList companiesList = gson.fromJson(jsonStr, CompaniesList.class);
		assertTrue(companiesList != null);
		assertTrue(companiesList.companies != null);
		assertTrue(companiesList.companies.size() == 2);
		assertTrue(companiesList.companies.get(1).getName().equals("name1"));
	}
	
	private class CompaniesList{
		public List<CompanyDTO> companies;
	}
	
}
