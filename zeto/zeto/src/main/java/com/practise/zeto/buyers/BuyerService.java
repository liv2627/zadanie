package com.practise.zeto.buyers;

import com.practise.zeto.buyers.BuyerEntity;
import com.practise.zeto.buyers.BuyerRepository;
import com.practise.zeto.products.ProductRepository;
import com.practise.zeto.sellers.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public BuyerDTO createBuyer(BuyerDTO buyerDTO) {

        var newBuyer = new BuyerEntity();
        newBuyer.setFirstName(buyerDTO.firstName());
        newBuyer.setLastName(buyerDTO.lastName());
        newBuyer.setEmail(buyerDTO.email());
        newBuyer.setPassword(buyerDTO.password());
        newBuyer.setProducts(buyerDTO.products());

        buyerRepository.save(newBuyer);
        return newBuyer.toDTO();
    }

    public List<BuyerDTO> readAllBuyers() {
        return buyerRepository
                .findAll()
                .stream()
                .map(BuyerEntity::toDTO)
                .toList();
    }

    public BuyerDTO updateBuyer(BuyerDTO buyerDTO, Long buyerToUpdateId) {

        var buyerToUpdate = buyerRepository
                .findById(buyerToUpdateId)
                .orElseThrow(() -> new NoSuchElementException("Buyer with id " + buyerToUpdateId + " does not exist"));

        buyerToUpdate.setFirstName(buyerDTO.firstName());
        buyerToUpdate.setProducts(buyerDTO.products());
        buyerToUpdate.setLastName(buyerDTO.lastName());
        buyerToUpdate.setPassword(buyerDTO.password());
        buyerToUpdate.setEmail(buyerDTO.email());

        buyerRepository.save(buyerToUpdate);

        return buyerToUpdate.toDTO();
    }

    public void deleteBuyer(Long buyerToDeleteId) {
        buyerRepository.deleteById(buyerToDeleteId);
    }

}