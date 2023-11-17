package com.alumnos.alumno.service

import com.alumnos.alumno.model.Estudiante
import com.alumnos.alumno.model.Libros
import com.alumnos.alumno.repository.EstudianteRepository
import com.alumnos.alumno.repository.LibrosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class LibrosService {
    @Autowired
    lateinit var EstudianteRepository: EstudianteRepository
    @Autowired
    lateinit var LibrosRepository: LibrosRepository

    fun list(): List<Libros> {
        return LibrosRepository.findAll()
    }


    fun save(libros: Libros): Libros{
        try{

            libros.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            libros.autor?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return LibrosRepository.save(libros)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(libro: Libros): Libros {
        try {
            LibrosRepository.findById(libro.id)
                ?: throw Exception("ID no existe")

            return LibrosRepository.save(libro)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(libro: Libros): Libros {
        try {
            val response = LibrosRepository.findById(libro.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombre = libro.nombre
            }
            return LibrosRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long?): Boolean? {
        try {
            val response = LibrosRepository.findById(id)
                ?: throw Exception("ID no existe")
            LibrosRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}
