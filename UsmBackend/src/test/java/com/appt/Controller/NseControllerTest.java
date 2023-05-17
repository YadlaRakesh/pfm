package com.appt.Controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appt.model.Nse;
import com.appt.repository.NseRepository;
import com.appt.service.NseService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class NseControllerTest {
	
	@Autowired
	@InjectMocks
	NseService nseService;
	
	@Mock
	NseRepository nseRepository;
	
	@Test
	void findBySymbolTest() {
		String symbol = "BATAINDIA";
		List<Nse> list = new ArrayList<>();
		list.add(new Nse("500043", "878.76", "India", "INR", "NSE", "2520", "Consumer Durables", "INE176A01028", "877.76","Consumer Discretionary", "BATA INDIA LTD.", "BATAINDIA","EQ"));
		list.add(new Nse("500124", "98.76","India", "INR", "NSE", "35", "Healthcare", "INE089A01023", "97.76","Healthcare", "DR.REDDY'S LABORATORIES LTD.", "DRREDDY","EQ"));
		
		when(nseRepository.findBySymbolStartsWith(symbol))
		.thenReturn(list);	
		
		int expected = 2;
		int actual = nseService.getBySymbol(symbol).size();
		
		Assertions.assertEquals(expected,actual);
	}
	
	@Test
	void findBySectorTest() {
		String sector = "Healthcare";
		List<Nse> listNse = new ArrayList<>();
		listNse.add(new Nse("500009", "87.76","India", "INR", "NSE", "35", "Healthcare", "INE432A01017", "86.76","Healthcare", "AMBALAL SARABHAI ENTERPRISES LTD.", "AMBALALSA","EQ"));
		listNse.add(new Nse("500124", "98.76","India", "INR", "NSE", "35", "Healthcare", "INE089A01023", "97.76","Healthcare", "DR.REDDY'S LABORATORIES LTD.", "DRREDDY","EQ"));
		
		when(nseRepository.findBySectorContaining(sector)).thenReturn(listNse);
		
		int expected = 2;
		int actual = nseService.findBySector(sector).size();
		Assertions.assertEquals(expected,actual);
	}
	
	@Test
	void findByIndustryTest() {
		String industry = "Financial Services";
		
		List<Nse> listNse = new ArrayList<>();
		listNse.add(new Nse("500111", "67.76","India", "INR", "NSE", "40201020", "Financial Services", "INE013A01015", "66.15","Financial Services", "RELIANCE CAPITAL LTD.", "RELCAPITAL","EQ"));
		listNse.add(new Nse("500112", "105.65","India", "INR", "NSE", "40201020", "Financial Services", "INE062A01020", "105.6","Financial Services", "STATE BANK OF INDIA", "SBIN","EQ"));
		listNse.add(new Nse("500116", "87.76","India", "INR", "NSE", "40201020", "Financial Services", "INE008A01015", "86.76","Financial Services", "IDBI BANK LTD.", "IDBI","EQ"));
		
		when(nseRepository.findByIndustryContaining(industry)).thenReturn(listNse);
		
		int expected = 3;
		int actual = nseService.fetchByIndustry(industry).size();
		
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void findBySecurityNameTest() {
		String securityName = "RELIANCE CAPITAL LTD.";

		List<Nse> list = new ArrayList<>();
		list.add(new Nse("500112", "2342.43","India", "INR", "NSE", "40201020", "Financial Services", "INE062A01020", "2342.43","Financial Services", "STATE BANK OF INDIA", "SBIN","EQ"));
		list.add(new Nse("500111", "873.76","India", "INR", "NSE", "40201020", "Financial Services", "INE013A01015", "873.76","Financial Services", "RELIANCE CAPITAL LTD.", "RELCAPITAL","EQ"));
		list.add(new Nse("500116", "87.76","India", "INR", "NSE", "40201020", "Financial Services", "INE008A01015", "86.76","Financial Services", "IDBI BANK LTD.", "IDBI","EQ"));
		when(nseRepository.findBySecurityNameStartsWith(securityName)).thenReturn(list);
		
		int expected = 3;
		int actual = nseService.fetchStocksBySecurityName(securityName).size();
		
		Assertions.assertEquals(expected, actual);
	}
}
