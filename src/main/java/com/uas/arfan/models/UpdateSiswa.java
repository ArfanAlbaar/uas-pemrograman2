package com.uas.arfan.models;

import java.sql.Date;

import lombok.Data;

@Data
public class UpdateSiswa {

    private Integer id;

    private String nisn;

    private String namaLengkap;

    private Date tanggalLahir;

    private String alamat;

    private String namaOrtu;

    private String telp;

    private byte[] foto;

    private boolean status;

    private Integer taId;
}