package com.uas.arfan.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.uas.arfan.entities.Siswa;
import com.uas.arfan.entities.TahunAjaran;
import com.uas.arfan.models.CreateSiswa;
import com.uas.arfan.models.UpdateSiswa;
import com.uas.arfan.repositories.SiswaRepo;
import com.uas.arfan.repositories.TahunAjaranRepo;

import jakarta.transaction.Transactional;

@Service
public class SiswaService {

    @Autowired
    private SiswaRepo repo;

    @Autowired
    TahunAjaranRepo taRepo;

    @Transactional
    public String simpanSiswa(CreateSiswa create, MultipartFile foto) throws IOException {
        Siswa siswa = new Siswa();
        TahunAjaran ta = taRepo.findById(create.getTaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tahun Ajaran is not found"));

        siswa.setNisn(create.getNisn());
        siswa.setNamaLengkap(create.getNamaLengkap());
        siswa.setTanggalLahir(create.getTanggalLahir());
        siswa.setAlamat(create.getAlamat());
        siswa.setNamaOrtu(create.getNamaOrtu());
        siswa.setTelp(create.getTelp());
        if (foto != null && !foto.isEmpty()) {
            siswa.setFoto(foto.getBytes());
        }

        siswa.setStatus(create.isStatus());
        siswa.setTa(ta);
        repo.save(siswa);
        return "Successfully created";
    }

    public List<Siswa> lihatSiswa() {
        return repo.findAll();
    }

    public Siswa getById(Integer id) {
        Siswa siswa = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Siswa is not found"));
        return siswa;
    }

    @Transactional
    public String ubahSiswa(Integer id, UpdateSiswa update, MultipartFile foto) throws IOException {
        Siswa siswa = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Siswa is not found"));
        TahunAjaran ta = taRepo.findById(update.getTaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tahun Ajaran is not found"));
        siswa.setId(id);
        siswa.setNisn(update.getNisn());
        siswa.setNamaLengkap(update.getNamaLengkap());
        siswa.setTanggalLahir(update.getTanggalLahir());
        siswa.setAlamat(update.getAlamat());
        siswa.setNamaOrtu(update.getNamaOrtu());
        siswa.setTelp(update.getTelp());
        if (foto != null && !foto.isEmpty()) {
            siswa.setFoto(foto.getBytes());
        }
        siswa.setStatus(update.isStatus());
        siswa.setTa(ta);
        repo.save(siswa);

        return "Succes updated the id : " + id;
    }

    @Transactional
    public String ubahFoto(Integer id, MultipartFile foto) throws IOException {
        Siswa siswa = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Siswa is not found"));
        siswa.setId(id);
        siswa.setFoto(foto.getBytes());
        repo.save(siswa);
        return "Success add Picture";
    }

    @Transactional
    public String hapusSiswa(Integer id) {
        repo.deleteById(id);
        return "Succes deleted the id : " + id;
    }

}
