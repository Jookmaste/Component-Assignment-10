package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se331.lab.entity.AuctionItem;
import se331.lab.service.AuctionItemService;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AuctionItemController {
    private final AuctionItemService auctionItemService;

    // ดึงข้อมูลทั้งหมด หรือค้นหาด้วย description (ข้อ 3.2)
    @GetMapping("/auction-items")
    public ResponseEntity<List<AuctionItem>> getAuctionItems(
            @RequestParam(required = false) String description) {
        if (description != null && !description.isEmpty()) {
            return ResponseEntity.ok(auctionItemService.getAuctionItemsByDescription(description));
        }
        return ResponseEntity.ok(auctionItemService.getAllAuctionItems());
    }

    // ค้นหา AuctionItem ที่ successfulBid น้อยกว่าค่าที่ระบุ (ข้อ 3.3)
    @GetMapping("/auction-items/filter-bid")
    public ResponseEntity<List<AuctionItem>> getBySuccessfulBidLessThan(
            @RequestParam Double value) {
        return ResponseEntity.ok(auctionItemService.getAuctionItemsBySuccessfulBidLessThan(value));
    }
}