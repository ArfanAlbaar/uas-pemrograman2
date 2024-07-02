package com.uas.arfan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.arfan.entities.Kehadiran;
import com.uas.arfan.models.CreateKehadiran;
import com.uas.arfan.services.KehadiranService;

@RestController
@RequestMapping("/api/att")
@CrossOrigin("*")
public class KehadiranController {

    @Autowired
    private KehadiranService service;

    @PostMapping("/create")
    public String simpanKehadiran(@RequestBody CreateKehadiran create) {
        return service.simpanKehadiran(create);
    }

    @GetMapping("/list")
    public List<Kehadiran> lihatKehadiran() {
        return service.lihatKehadiran();
    }

    @GetMapping("/{id}")
    public Kehadiran getById(@PathVariable Integer id) {
        return service.getById(id);
    }

}
