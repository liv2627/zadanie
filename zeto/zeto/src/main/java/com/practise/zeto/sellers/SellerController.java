package com.practise.zeto.sellers;

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
@RequestMapping("/api/sellers")
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    SellerDTO createSeller(@RequestBody SellerDTO sellerDTO) {
        return sellerService.createSeller(sellerDTO);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    List<SellerDTO> getAllSellers() {
        return sellerService.readAllSellers();
    }

    @PutMapping("/{sellerId}")
    @ResponseStatus(HttpStatus.OK)
    SellerDTO updateSeller(@RequestBody SellerDTO sellerDTO, @PathVariable Long sellerId) {
        return sellerService.updateSeller(sellerDTO, sellerId);
    }

    @DeleteMapping("/{sellerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCourseById(@PathVariable Long sellerId) {
        sellerService.deleteSeller(sellerId);
    }

}