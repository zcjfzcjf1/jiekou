package com.neo.repository;

import com.neo.entity.Factory;
import com.neo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FactoryRepository extends JpaRepository<Factory, Long> {

    @Query(value = "select f.* from factory f LIMIT ?1,?2", nativeQuery = true)
    @Modifying
    public  List<Factory>  getFactoryAll(int page ,int leng);


    Factory findFactoryByFactoryId(String factoryId);
}