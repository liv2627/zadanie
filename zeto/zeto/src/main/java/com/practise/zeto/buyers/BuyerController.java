package com.practise.zeto.buyers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** REST Controller created in the needs of Create, Read, Update, Delete
 * and more complex operations for Product Entity
 * @Endpoint: products
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/buyers")
public class BuyerController {

    private final BuyerService buyerService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    BuyerDTO createBuyer(@RequestBody BuyerDTO buyerDTO) {
        return buyerService.createBuyer(buyerDTO);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    List<BuyerDTO> getAllBuyers() {
        return buyerService.readAllBuyers();
    }

    @PutMapping("/{buyerId}")
    @ResponseStatus(HttpStatus.OK)
    BuyerDTO updateBuyer(@RequestBody BuyerDTO buyerDTO, @PathVariable Long buyerId) {
        return buyerService.updateBuyer(buyerDTO, buyerId);
    }

    @DeleteMapping("/{buyerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCourseById(@PathVariable Long buyerId) {
        buyerService.deleteBuyer(buyerId);
    }

}