package com.example.sabor.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plato")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Plato extends Base {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private int precio;
    @Column(name = "rubro")
    private String rubro;
    @Column(name = "imagen")
    private String imagenPath;
    @Column(name = "ingredientes")
    private ArrayList<String> ingredientes = new ArrayList<>();
}
