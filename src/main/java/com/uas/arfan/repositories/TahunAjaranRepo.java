package com.uas.arfan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uas.arfan.entities.TahunAjaran;

@Repository
public interface TahunAjaranRepo extends JpaRepository<TahunAjaran, Integer> {

}
