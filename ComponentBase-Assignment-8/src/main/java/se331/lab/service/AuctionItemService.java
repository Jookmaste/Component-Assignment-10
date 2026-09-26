package se331.lab.service;

import se331.lab.entity.AuctionItem;
import java.util.List;

public interface AuctionItemService {
    List<AuctionItem> getAllAuctionItems();
    List<AuctionItem> getAuctionItemsByDescription(String description);
    List<AuctionItem> getAuctionItemsBySuccessfulBidLessThan(Double value);
}