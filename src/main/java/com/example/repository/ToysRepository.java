package com.example.repository;

import com.example.model.Toys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToysRepository extends JpaRepository<Toys,Integer> {


}
