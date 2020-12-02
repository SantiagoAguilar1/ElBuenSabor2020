package com.example.sabor.services;
import com.example.sabor.entities.Plato;
import com.example.sabor.repositories.BaseRepository;
import com.example.sabor.repositories.PlatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl extends BaseServiceImpl<Plato, Long> implements PlatoService{
    @Autowired
    private PlatoRepository platoRepository;
    public PlatoServiceImpl(BaseRepository<Plato, Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public List<Plato> search(String filtro) throws Exception {
        try{
            List<Plato> platos = platoRepository.searchNativo(filtro);
            return platos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Plato> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Plato> platos = platoRepository.searchNativo(filtro, pageable);
            return platos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
