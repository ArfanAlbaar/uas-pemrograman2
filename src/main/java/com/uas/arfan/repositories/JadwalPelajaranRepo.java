package com.uas.arfan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uas.arfan.entities.JadwalPelajaran;

@Repository
public interface JadwalPelajaranRepo extends JpaRepository<JadwalPelajaran, Integer> {

}
