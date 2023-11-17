package com.alumnos.alumno.controller

import com.alumnos.alumno.model.Libros
import com.alumnos.alumno.service.LibrosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/libros")   //endpoint
class LibroController {
    @Autowired
    lateinit var librosService: LibrosService

    @GetMapping
    fun list ():List <Libros>{
        return librosService.list()
    }
    @PostMapping
    fun save (@RequestBody libros: Libros):ResponseEntity<Libros>{
        return ResponseEntity(librosService.save(libros), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody libros: Libros):ResponseEntity<Libros>{
        return ResponseEntity(librosService.update(libros), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody libros: Libros):ResponseEntity<Libros>{
        return ResponseEntity(librosService.updateName(libros), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return librosService.delete(id)
    }
}