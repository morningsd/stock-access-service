package edu.demian.authservice.service;

import edu.demian.authservice.model.StockInformation;
import edu.demian.authservice.repository.StockInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockInformationService {

  private final StockInformationRepository stockInformationRepository;

  public StockInformationService(StockInformationRepository stockInformationRepository) {
    this.stockInformationRepository = stockInformationRepository;
  }

  public List<StockInformation> find5WithTheBiggestLatestPrice() {
    return stockInformationRepository.findTop5ByOrderByLatestPriceDesc();
  }

  public List<StockInformation> find5WithTheBiggestChangePercent() {
    return stockInformationRepository.findTop5ByOrderByChangePercentDesc();
  }

}
