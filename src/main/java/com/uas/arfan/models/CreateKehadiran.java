package com.uas.arfan.models;

import java.sql.Date;

import com.uas.arfan.entities.AttendCategory;

import lombok.Data;

@Data
public class CreateKehadiran {

    private AttendCategory kehadiran;

    private Date tgl;

    private String keterangan;

    private Integer siswaId;

}
