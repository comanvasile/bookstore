package repository;

import model.Sale;

import java.util.List;

public interface SaleRepository {
    List<Sale> findAll();


    Sale create(Sale sale);

    Sale update(Sale sale);

    boolean deleteById(Long id);
}
