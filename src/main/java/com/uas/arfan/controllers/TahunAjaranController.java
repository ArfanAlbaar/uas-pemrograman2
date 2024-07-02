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

import com.uas.arfan.entities.TahunAjaran;
import com.uas.arfan.services.TahunAjaranService;

@RestController
@RequestMapping("/api/ta")
@CrossOrigin("*")
public class TahunAjaranController {

    @Autowired
    private TahunAjaranService service;

    @PostMapping("/create")
    public String simpanTA(@RequestBody TahunAjaran create) {
        return service.simpanTA(create);
    }

    @GetMapping("/list")
    public List<TahunAjaran> lihatTA() {
        return service.lihatTA();
    }

    @GetMapping("/{taId}")
    public TahunAjaran getById(@PathVariable Integer taId) {
        return service.getById(taId);
    }

    @PutMapping("/{taId}")
    public String ubahTA(@RequestBody TahunAjaran update, @PathVariable Integer taId) {
        return service.ubahTA(update, taId);
    }

    @DeleteMapping("/{taId}")
    public String hapusTA(@PathVariable Integer taId) {
        return service.hapusTA(taId);
    }
}
