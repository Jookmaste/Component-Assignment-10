package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab.entity.AuctionItem;
import se331.lab.repository.AuctionItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService {
    private final AuctionItemRepository auctionItemRepository;

    @Override
    public List<AuctionItem> getAllAuctionItems() {
        return auctionItemRepository.findAll();
    }

    @Override
    public List<AuctionItem> getAuctionItemsByDescription(String description) {
        return auctionItemRepository.findByDescriptionContainingIgnoreCase(description);
    }

    @Override
    public List<AuctionItem> getAuctionItemsBySuccessfulBidLessThan(Double value) {
        return auctionItemRepository.findBySuccessfulBidAmountLessThan(value);
    }
}