package service;

import model.Sale;

import java.util.List;

public interface SaleService {
    Sale save(Sale sale);

    void delete(Long id);

    List<Sale> findAll();

    Double calculate();
}
