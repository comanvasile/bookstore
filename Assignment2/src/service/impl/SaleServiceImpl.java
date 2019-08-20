package service.impl;

import model.Sale;
import repository.SaleRepository;
import service.SaleService;

import java.util.List;
import java.util.Observable;

public class SaleServiceImpl extends Observable implements SaleService {
    private SaleRepository saleRepository;

    public  SaleServiceImpl(SaleRepository saleRepository){
        this.saleRepository=saleRepository;
    }

    @Override
    public Sale save(Sale sale) {
        if(sale.getId()!=null){
            return this.saleRepository.update(sale);
        }
        else{
           return  this.saleRepository.create(sale);
        }
    }

    @Override
    public void delete(Long id) {
        this.saleRepository.deleteById(id);
    }

    @Override
    public List<Sale> findAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public Double calculate(){
      return  this.saleRepository.findAll().stream().mapToDouble(book->book.getPrice()).sum();
    }
}
