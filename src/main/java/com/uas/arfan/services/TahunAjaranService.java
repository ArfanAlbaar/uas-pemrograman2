package com.uas.arfan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.uas.arfan.entities.TahunAjaran;
import com.uas.arfan.repositories.TahunAjaranRepo;

import jakarta.transaction.Transactional;

@Service
public class TahunAjaranService {

    @Autowired
    private TahunAjaranRepo repo;

    @Transactional
    public String simpanTA(TahunAjaran create) {
        repo.save(create);
        return "Success";
    }

    public List<TahunAjaran> lihatTA() {
        return repo.findAll();
    }

    public TahunAjaran getById(Integer taId) {
        return repo.findById(taId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tahun Ajaran is not found"));
    }

    @Transactional
    public String ubahTA(TahunAjaran update, Integer id) {
        TahunAjaran ta = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tahun Ajaran is not found"));
        ta.setId(id);
        ta.setPeriode(update.getPeriode());
        ta.setTglMulai(update.getTglMulai());
        ta.setTglAkhir(update.getTglAkhir());
        ta.setKurikulum(update.getKurikulum());
        repo.save(ta);
        return "Succes updated the id : " + id;
    }

    @Transactional
    public String hapusTA(Integer id) {
        repo.deleteById(id);
        return "Succes deleted the id : " + id;
    }

}
