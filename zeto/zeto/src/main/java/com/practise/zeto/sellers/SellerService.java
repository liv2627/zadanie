package com.practise.zeto.sellers;

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
public class SellerService
{

    private final SellerRepository sellerRepository;

    public SellerDTO createSeller(SellerDTO sellerDTO)
    {

        var newSeller = new SellerEntity();
        newSeller.setProducts(sellerDTO.products());
        newSeller.setCompanyName(sellerDTO.companyName());
        newSeller.setAddress(sellerDTO.address());

        sellerRepository.save(newSeller);
        return newSeller.toDTO();
    }

    public List<SellerDTO> readAllSellers()
    {
        return sellerRepository
                .findAll()
                .stream()
                .map(SellerEntity::toDTO)
                .toList();
    }

    public SellerDTO updateSeller(SellerDTO sellerDTO, Long sellerToUpdateId)
    {

        var sellerToUpdate = sellerRepository
                .findById(sellerToUpdateId)
                .orElseThrow(() -> new NoSuchElementException("Seller with id " + sellerToUpdateId + " does not exist"));

        sellerToUpdate.setAddress(sellerDTO.address());
        sellerToUpdate.setProducts(sellerDTO.products());
        sellerToUpdate.setCompanyName(sellerDTO.companyName());

        sellerRepository.save(sellerToUpdate);

        return sellerToUpdate.toDTO();
    }

    public void deleteSeller(Long sellerToDeleteId) {
        sellerRepository.deleteById(sellerToDeleteId);
    }

}