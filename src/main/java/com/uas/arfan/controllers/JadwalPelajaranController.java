package com.uas.arfan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.arfan.entities.JadwalPelajaran;
import com.uas.arfan.models.CreateJP;
import com.uas.arfan.services.JadwalPelajaranService;

@RestController
@RequestMapping("/api/jp")
@CrossOrigin("*")
public class JadwalPelajaranController {

    @Autowired
    private JadwalPelajaranService service;

    @PostMapping("/create")
    public String simpanJadwal(@RequestBody CreateJP create) {
        return service.simpanJadwal(create);
    }

    @GetMapping("/list")
    public List<JadwalPelajaran> lihatJadwal() {
        return service.lihatJadwal();
    }

    @GetMapping("/{jpId}")
    public JadwalPelajaran getById(@PathVariable Integer jpId) {
        return service.getById(jpId);
    }

    @PutMapping("/{jpId}")
    public String ubahJadwal(@RequestBody CreateJP update, @PathVariable Integer jpId) {
        return service.ubahJadwal(update, jpId);
    }

    @DeleteMapping("/{jpId}")
    public String hapusJadwal(@PathVariable Integer jpId) {
        return service.hapusJadwal(jpId);
    }
}
