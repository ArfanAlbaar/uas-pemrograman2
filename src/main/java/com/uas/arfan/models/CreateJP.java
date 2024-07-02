package com.uas.arfan.models;

import java.util.List;

import com.uas.arfan.entities.Day;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateJP {

    private Integer idMapel;
    private Integer idGuru;
    private Integer idKelas;
    private Day hari;
    private Integer jamMulai;
    private Integer jamSelesai;
    private List<Integer> siswaIds;

}
