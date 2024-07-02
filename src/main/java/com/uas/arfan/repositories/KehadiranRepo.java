package com.uas.arfan.repositories;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uas.arfan.entities.Kehadiran;
import com.uas.arfan.entities.Siswa;

@Repository
public interface KehadiranRepo extends JpaRepository<Kehadiran, Integer> {

    Optional<Kehadiran> findBySiswaAndTgl(Siswa siswa, Date tgl);

}