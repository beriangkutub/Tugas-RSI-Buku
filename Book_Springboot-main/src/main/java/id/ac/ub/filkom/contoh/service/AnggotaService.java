package id.ac.ub.filkom.contoh.service;

import id.ac.ub.filkom.contoh.entity.Anggota;
import id.ac.ub.filkom.contoh.repository.AnggotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaService {

    private final AnggotaRepository anggotaRepository;

    public AnggotaService(AnggotaRepository anggotaRepository) {
        this.anggotaRepository = anggotaRepository;
    }

    public List<Anggota> daftarAnggota() {
        return anggotaRepository.findAll();
    }

    public Anggota tambahAnggota(String idAnggota, String nama, String alamat) {
        String id = idAnggota.trim();
        String namaBersih = nama.trim();
        String alamatBersih = alamat.trim();
        if (id.isEmpty() || namaBersih.isEmpty() || alamatBersih.isEmpty()) {
            throw new IllegalArgumentException("Semua data anggota wajib diisi");
        }
        return anggotaRepository.save(new Anggota(id, namaBersih, alamatBersih));
    }
}