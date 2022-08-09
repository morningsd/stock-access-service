package edu.demian.authservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.demian.authservice.dto.StockInformationDto;
import edu.demian.authservice.service.StockInformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-information")
public class StockInformationController {

    private final StockInformationService stockInformationService;
    private final ObjectMapper mapper;

    public StockInformationController(StockInformationService stockInformationService, ObjectMapper mapper) {
        this.stockInformationService = stockInformationService;
        this.mapper = mapper;
    }


    @GetMapping("/latest-price")
    public ResponseEntity<List<StockInformationDto>> find5WithTheBiggestLatestPrice() {
        return new ResponseEntity<>(
                mapper.convertValue(stockInformationService.find5WithTheBiggestLatestPrice(), new TypeReference<List<StockInformationDto>>() {}),
                HttpStatus.OK
        );
    }

    @GetMapping("/change-percent")
    public ResponseEntity<List<StockInformationDto>> find5WithTheBiggestChangePercent() {
        return new ResponseEntity<>(
                mapper.convertValue(stockInformationService.find5WithTheBiggestChangePercent(), new TypeReference<List<StockInformationDto>>() {}),
                HttpStatus.OK
        );
    }

}
