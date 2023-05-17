package com.appt.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appt.dto.NseResponseDto;
import com.appt.exception.ResourceNotFoundException;
import com.appt.model.Nse;
import com.appt.model.Stock;
import com.appt.repository.NseRepository;
import com.appt.repository.StocksRepository;

@Service
public class NseService {

	@Autowired
	private NseRepository nseRepo;

	@Autowired
	private StocksRepository stockRepo;

	@PostConstruct
	public void newNseData() throws IOException {

		String line = "";
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/16AprilTrade.csv"));
		try {

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");

				Stock s = new Stock();

				s.setSymbol(data[0]);
				s.setSeries(data[1]);
				s.setClose(data[2]);
				s.setLast(data[3]);
				s.setIsinNo(data[4]);

				stockRepo.save(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
	}

	@PostConstruct
	public void saveNseData() throws IOException {

		String line = "";
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Stocks.csv"));
		try {

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");

				Nse n = new Nse();
				n.setSecurityCode(data[0]);
				n.setSymbol(data[1]);
				n.setSecurityName(data[2]);
				n.setIsinNo(data[3]);
				n.setSector(data[4]);
				n.setIndustry(data[5]);
				n.setExchange(data[6]);
				n.setCurrency(data[7]);
				n.setGics(data[8]);
				n.setCountry(data[9]);
				n.setSeries(data[10]);
				n.setClose(data[11]);
				n.setLast(data[12]);

//				Stock stock = stockRepo.findByIsinNo(n.getIsinNo());
//				if (stock != null) {
//					n.setClose(stock.getClose());
//					n.setLast(stock.getLast());
//				}

				nseRepo.save(n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
	}

	public List<Nse> allStocks() {
		return nseRepo.findAll();
	}

	public Nse findByIsinNo(String isinNo) {
		Optional<Nse> stock = nseRepo.findByIsinNo(isinNo);
		if (stock.isPresent()) {
			return stock.get();
		} else {
			throw new ResourceNotFoundException("Stock not Found with ISIN No:" + isinNo);
		}
	}

	public List<Nse> getBySymbol(String symbol) throws ResourceNotFoundException {
		List<Nse> stock = nseRepo.findBySymbolStartsWith(symbol);
		if (stock == null) {
			throw new ResourceNotFoundException("Stock not Found with symbol:" + symbol);
		} else {
			return stock;
		}

	}

	public List<Nse> findBySector(String sector) {
		List<Nse> stock = nseRepo.findBySectorContaining(sector);
		if (stock != null) {
			return stock;
		} else {
			throw new ResourceNotFoundException("Stocks not Found with sector:" + sector);
		}

	}

	public List<NseResponseDto> fetchByIndustry(String industry) {
		List<Nse> stocks = nseRepo.findByIndustryContaining(industry);
		if (stocks != null) {
			List<NseResponseDto> listDto = new ArrayList<>();

			for (Nse nse : stocks) {
				NseResponseDto dto = new NseResponseDto();
				dto.setIsinNo(nse.getIsinNo());
				dto.setSecurityName(nse.getSecurityName());
				dto.setSymbol(nse.getSymbol());
				dto.setSector(nse.getSector());
				dto.setIndustry(nse.getIndustry());
				dto.setCountry(nse.getCountry());
				dto.setClose(nse.getClose());
				dto.setLast(nse.getLast());
				listDto.add(dto);
			}
			return listDto;
		} else {
			throw new ResourceNotFoundException("Please enter valid Industry!");
		}

	}

	public List<NseResponseDto> fetchStocksBySecurityName(String securityName) {
		List<Nse> list = nseRepo.findBySecurityNameStartsWith(securityName);
		if(list!=null) {
			List<NseResponseDto> listDto = new ArrayList<>();
			for (Nse stock : list) {
				NseResponseDto dto = new NseResponseDto();
				dto.setIsinNo(stock.getIsinNo());
				dto.setSecurityName(stock.getSecurityName());
				dto.setSector(stock.getSector());
				dto.setSymbol(stock.getSymbol());
				dto.setIndustry(stock.getIndustry());
				dto.setCountry(stock.getCountry());
				dto.setLast(stock.getLast());
				dto.setClose(stock.getClose());

				listDto.add(dto);
			}
			return listDto;
		} else {
			throw new ResourceNotFoundException("Please enter valid sector!");
		}
	}
}
