package com.uas.arfan.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nisn", nullable = false, unique = true)
    private String nisn;

    private String namaLengkap;

    private Date tanggalLahir;

    private String alamat;

    private String namaOrtu;

    private String telp;

    @Lob
    @Column(name = "foto", columnDefinition = "LONGBLOB")
    private byte[] foto;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "ta_id", referencedColumnName = "id")
    private TahunAjaran ta;

}
