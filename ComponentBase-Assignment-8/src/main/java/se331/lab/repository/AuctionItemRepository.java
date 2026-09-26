package se331.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se331.lab.entity.AuctionItem;

import java.util.List;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    List<AuctionItem> findByDescriptionContainingIgnoreCase(String description);

    @Query("SELECT a FROM AuctionItem a WHERE a.successfulBid.amount < :value")
    List<AuctionItem> findBySuccessfulBidAmountLessThan(@Param("value") Double value);
}