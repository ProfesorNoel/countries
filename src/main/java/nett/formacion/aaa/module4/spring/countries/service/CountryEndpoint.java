package nett.formacion.aaa.module4.spring.countries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import nett.formacion.aaa.module4.spring.countries.repo.CountryLocalRepo;
import nett.formacion.aaa.module4.spring.countries.ws.GetCountryRequest;
import nett.formacion.aaa.module4.spring.countries.ws.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://ws.countries.spring.module4.aaa.formacion.nett";
	
	private CountryLocalRepo countryRepository;

	@Autowired
	public CountryEndpoint(CountryLocalRepo countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
}
