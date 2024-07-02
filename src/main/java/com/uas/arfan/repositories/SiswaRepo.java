package com.uas.arfan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uas.arfan.entities.Siswa;

@Repository
public interface SiswaRepo extends JpaRepository<Siswa, Integer> {

}
