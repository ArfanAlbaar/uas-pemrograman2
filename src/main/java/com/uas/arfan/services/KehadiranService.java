package com.uas.arfan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.uas.arfan.entities.Kehadiran;
import com.uas.arfan.entities.Siswa;
import com.uas.arfan.models.CreateKehadiran;
import com.uas.arfan.repositories.KehadiranRepo;
import com.uas.arfan.repositories.SiswaRepo;

import jakarta.transaction.Transactional;

@Service
public class KehadiranService {

    @Autowired
    private KehadiranRepo repo;

    @Autowired
    private SiswaRepo siswaRepo;

    @Transactional
    public String simpanKehadiran(CreateKehadiran create) {
        Siswa siswa = siswaRepo.findById(create.getSiswaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Siswa is not found"));
        Optional<Kehadiran> existingKehadiran = repo.findBySiswaAndTgl(siswa, create.getTgl());
        if (existingKehadiran.isPresent()) {

            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Siswa sudah absen hari ini");

        }
        Kehadiran kehadiran = new Kehadiran();
        kehadiran.setKehadiran(create.getKehadiran());
        kehadiran.setTgl(create.getTgl());
        kehadiran.setKeterangan(create.getKeterangan());
        kehadiran.setSiswa(siswa);

        repo.save(kehadiran);
        return "Kehadiran berhasil disimpan";
    }

    public List<Kehadiran> lihatKehadiran() {
        return repo.findAll();
    }

    public Kehadiran getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kehadiran is not found"));
    }
}
