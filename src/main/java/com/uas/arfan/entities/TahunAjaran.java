package com.uas.arfan.entities;

import java.sql.Date;
import java.time.Year;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TahunAjaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Year periode;

    private Date tglMulai;

    private Date tglAkhir;

    private String kurikulum;
}
