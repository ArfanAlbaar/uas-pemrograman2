package com.uas.arfan.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.uas.arfan.entities.JadwalPelajaran;
import com.uas.arfan.entities.Siswa;
import com.uas.arfan.models.CreateJP;
import com.uas.arfan.repositories.JadwalPelajaranRepo;
import com.uas.arfan.repositories.SiswaRepo;

import jakarta.transaction.Transactional;

@Service
public class JadwalPelajaranService {

    @Autowired
    private JadwalPelajaranRepo repo;

    @Autowired
    private SiswaRepo siswaRepo;

    @Transactional
    public String simpanJadwal(CreateJP create) {

        List<Siswa> siswaList = create.getSiswaIds().stream()
                .map(siswaId -> siswaRepo.findById(siswaId)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Siswa with ID " + siswaId + " is not found")))
                .collect(Collectors.toList());

        JadwalPelajaran jp = new JadwalPelajaran();
        jp.setIdMapel(create.getIdMapel());
        jp.setIdGuru(create.getIdGuru());
        jp.setIdKelas(create.getIdKelas());
        jp.setHari(create.getHari());
        jp.setJamMulai(create.getJamMulai());
        jp.setJamSelesai(create.getJamSelesai());
        jp.setSiswa(siswaList);

        repo.save(jp);
        return "Successfully created";
    }

    public List<JadwalPelajaran> lihatJadwal() {
        return repo.findAll();
    }

    public JadwalPelajaran getById(Integer jpId) {
        return repo.findById(jpId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran is not found"));
    }

    @Transactional
    public String ubahJadwal(CreateJP update, Integer id) {

        JadwalPelajaran jp = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran is not found"));
        List<Siswa> siswaList = update.getSiswaIds().stream()
                .map(siswaId -> siswaRepo.findById(siswaId)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Siswa with ID " + siswaId + " is not found")))
                .collect(Collectors.toList());

        jp.setId(id);
        jp.setIdMapel(update.getIdMapel());
        jp.setIdGuru(update.getIdGuru());
        jp.setIdKelas(update.getIdKelas());
        jp.setHari(update.getHari());
        jp.setJamMulai(update.getJamMulai());
        jp.setJamSelesai(update.getJamSelesai());
        jp.setSiswa(siswaList);
        repo.save(jp);
        return "Succes updated the id : " + id;
    }

    @Transactional
    public String hapusJadwal(Integer id) {
        repo.deleteById(id);
        return "Succesfully deleted the id : " + id;
    }

}
