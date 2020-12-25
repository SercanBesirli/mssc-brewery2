package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(beerId).beerName("Galaxy").beerStyle("Pale Ale").build();
    }

    @Override
    public BeerDto createNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).beerStyle("Free").beerName("New").upc(3L).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting beer .. " + beerId);
    }
}
