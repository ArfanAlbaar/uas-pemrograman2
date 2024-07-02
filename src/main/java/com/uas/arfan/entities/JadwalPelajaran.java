package com.uas.arfan.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class JadwalPelajaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idMapel;

    private Integer idGuru;

    private Integer idKelas;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Day hari;

    private Integer jamMulai;

    private Integer jamSelesai;

    @ManyToMany
    @JoinTable(name = "jp_siswa", joinColumns = @JoinColumn(name = "jp_id"), inverseJoinColumns = @JoinColumn(name = "siswa_id"))
    private List<Siswa> siswa;

}
