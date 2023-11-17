package com.alumnos.alumno.repository

import com.alumnos.alumno.model.Libros
import org.springframework.data.jpa.repository.JpaRepository

interface LibrosRepository : JpaRepository<Libros, Long?> {

        fun findById (id: Long?): Libros?
}