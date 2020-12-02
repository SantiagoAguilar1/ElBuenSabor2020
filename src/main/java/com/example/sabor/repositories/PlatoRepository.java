package com.example.sabor.repositories;

import com.example.sabor.entities.Plato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatoRepository extends BaseRepository <Plato,Long> {
    List<Plato> findByNombreContainingOrRubroContaining(String nombre, String rubro);
    Page<Plato> findByNombreContainingOrRubroContaining(String nombre, String rubro, Pageable pageable);

    @Query(value = "SELECT p FROM Plato p WHERE p.nombre LIKE %:filtro% OR p.rubro LIKE %:filtro%")
    List<Plato> search(@Param("filtro") String filtro);
    @Query(value = "SELECT p FROM Plato p WHERE p.nombre LIKE %:filtro% OR p.rubro LIKE %:filtro%")
    Page<Plato> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT p FROM Plato p WHERE p.nombre LIKE %:filtro% OR p.rubro LIKE %:filtro%",
            nativeQuery = true
    )
    List<Plato> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT p FROM Plato p WHERE p.nombre LIKE %:filtro% OR p.rubro LIKE %:filtro%",
            countQuery = "SELECT count (*) From plato",
            nativeQuery = true
    )
    Page<Plato> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
