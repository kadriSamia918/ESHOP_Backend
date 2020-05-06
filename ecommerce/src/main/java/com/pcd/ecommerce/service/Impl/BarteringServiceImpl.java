package com.pcd.ecommerce.service.Impl;
import com.pcd.ecommerce.model.Bartering;
import com.pcd.ecommerce.model.Product;
import com.pcd.ecommerce.service.BarteringService;
import com.pcd.ecommerce.dao.BarteringRepository;
import com.pcd.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BarteringServiceImpl implements BarteringService {

    @Autowired
    private BarteringRepository barteringRepository;

    @Autowired
    private ProductService productService;

    public BarteringServiceImpl() {
    }

    @Override
    public Bartering createBartering(Bartering bartering){ return this.barteringRepository.save(bartering);}

    @Override
    public Bartering updateBartering(Bartering bartering){return this.barteringRepository.save(bartering);}

    @Override
    public Bartering getBarteringById(Long id){return this.barteringRepository.findById(id).get();}

    @Override
    public  List<Bartering> getAllBartering(){return this.barteringRepository.findAll();}

    @Override
    public void deleteBarteringById(Long id){this.barteringRepository.deleteById(id);}


   @Override
   public void switchOwners(long user1, long product1, long user2, long product2){

       this.productService.setOwner(user1,product2);
       this.productService.setOwner(user2,product1);

   }

   @Override
    public Bartering uploadBartering(long id, MultipartFile image) throws IOException {
       Optional<Bartering> barteringDb = barteringRepository.findById(id);
       if (barteringDb.isPresent()) {
           System.out.println("image bytes....."+image.getBytes());
           Bartering barteringUpload = barteringDb.get();
           barteringUpload.setBarteringImage(image.getBytes());

           return  barteringRepository.save(barteringUpload);
       }
       else {
           throw new IOException("cannot upload image");
       }
   }

   @Override
    public List<Bartering> getAllBySourceUser(long id){
        return this.barteringRepository.getAllBySourceUser_Id(id);
   }


}
