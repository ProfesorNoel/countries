package nett.formacion.aaa.module4.spring.countries.repo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import nett.formacion.aaa.module4.spring.countries.ws.Country;
import nett.formacion.aaa.module4.spring.countries.ws.Currency;

@Component
public class CountryLocalRepo {

	private static final List<Country> countries = new ArrayList<Country>();
	
	public CountryLocalRepo() {
		super();
	}	
	
	@PostConstruct
	public void initData() {
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);

		countries.add(spain);

		Country poland = new Country();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);

		countries.add(poland);

		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		countries.add(uk);
	}

	public Country findCountry(String name) {
		
		Assert.notNull(name);

		Country result = null;

		for (Country country : countries) {
			if (name.equals(country.getName())) {
				result = country;
			}
		}

		return result;
	}
}