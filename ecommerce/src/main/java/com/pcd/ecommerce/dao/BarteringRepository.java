package com.pcd.ecommerce.dao;
import com.pcd.ecommerce.model.Bartering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarteringRepository  extends JpaRepository<Bartering, Long> {
   List<Bartering> getAllBySourceUser_Id(long id);
}
