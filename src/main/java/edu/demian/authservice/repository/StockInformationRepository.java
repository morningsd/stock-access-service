package edu.demian.authservice.repository;

import edu.demian.authservice.model.StockInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInformationRepository extends JpaRepository<StockInformation, Long> {

    @Query(value = "SELECT cs.* FROM company_stock cs " +
            "INNER JOIN (SELECT company_name, MAX(latest_update) AS max_latest_update from company_stock group by company_name) csm " +
            "ON cs.company_name = csm.company_name AND cs.latest_update = csm.max_latest_update " +
            "WHERE cs.latest_price IS NOT NULL ORDER BY cs.latest_price DESC LIMIT 5", nativeQuery = true)
    List<StockInformation> findTop5ByOrderByLatestPriceDesc();


    @Query(value = "SELECT cs.* FROM company_stock cs " +
            "INNER JOIN (SELECT company_name, MAX(latest_update) AS max_latest_update from company_stock group by company_name) csm " +
            "ON cs.company_name = csm.company_name AND cs.latest_update = csm.max_latest_update " +
            "WHERE cs.change_percent IS NOT NULL ORDER BY cs.change_percent DESC LIMIT 5", nativeQuery = true)
    List<StockInformation> findTop5ByOrderByChangePercentDesc();

}
