package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerDtoById() {
        BeerDto dto = breweryClient.getBeerDtoById(UUID.randomUUID());
        System.out.println(dto);
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Zubr").build();
        URI uri = breweryClient.saveNewBeer(beerDto);
        System.out.println(uri);
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Zubr").build();
        breweryClient.updateBeer(beerDto.getId(), beerDto);
    }

    @Test
    void deleteBear() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}