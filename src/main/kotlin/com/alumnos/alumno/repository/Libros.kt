package com.alumnos.alumno.repository

import com.alumnos.alumno.model.Estudiante
import com.alumnos.alumno.model.Libros
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LibrosRepository : JpaRepository<Libros, Long?> {

    fun findById (id: Long?): Libros?

}