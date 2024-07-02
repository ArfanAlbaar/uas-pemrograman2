package com.uas.arfan.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uas.arfan.entities.Siswa;
import com.uas.arfan.models.CreateSiswa;
import com.uas.arfan.models.UpdateSiswa;
import com.uas.arfan.services.SiswaService;

@RestController
@RequestMapping("/api/siswa")
@CrossOrigin("*")
public class SiswaController {

    @Autowired
    private SiswaService service;

    @PostMapping(path = "/create", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public String simpanSiswa(
            @RequestPart("siswa") CreateSiswa create,
            @RequestPart(value = "foto", required = false) MultipartFile foto) {
        try {
            return service.simpanSiswa(create, foto);
        } catch (IOException e) {
            throw new RuntimeException("Error saving document", e);
        }
    }

    @GetMapping("/list")
    public List<Siswa> lihatSiswa() {
        return service.lihatSiswa();
    }

    @GetMapping("/{siswaId}")
    public Siswa getById(@PathVariable Integer siswaId) {
        return service.getById(siswaId);
    }

    @PatchMapping(path = "/{siswaId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String ubahSiswa(@RequestPart("siswa") UpdateSiswa update,
            @PathVariable Integer siswaId,
            @RequestParam(value = "foto", required = false) MultipartFile foto) {
        try {
            return service.ubahSiswa(siswaId, update, foto);
        } catch (IOException e) {
            throw new RuntimeException("Error saving document", e);
        }
    }
    // @PatchMapping("/{siswaId}")
    // public String ubahSiswa(@RequestBody UpdateSiswa update,
    // @PathVariable Integer siswaId) {
    // return service.ubahSiswa(update, siswaId);
    // }

    @PatchMapping(path = "/{siswaId}/foto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String ubahFoto(@PathVariable Integer siswaId,
            @RequestParam("foto") MultipartFile foto) {
        try {
            return service.ubahFoto(siswaId, foto);
        } catch (IOException e) {
            throw new RuntimeException("Error saving document", e);
        }
    }

    @DeleteMapping("/{siswaId}")
    public String hapusSiswa(@PathVariable Integer siswaId) {
        return service.hapusSiswa(siswaId);
    }
}
