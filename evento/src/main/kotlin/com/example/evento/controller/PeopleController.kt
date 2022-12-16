package com.example.evento.controller

import com.example.evento.model.People
import com.example.evento.service.PeopleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/people")
class PeopleController {
    @Autowired
    lateinit var peopleService: PeopleService
    @GetMapping("/{id}")

    fun listById (@PathVariable("id") id: Long): ResponseEntity<People> {
        return ResponseEntity(peopleService.listById(id), HttpStatus.OK)
    }

    @GetMapping
    fun list():List<People>{
        return peopleService.list()
    }

    @PostMapping
    fun save(@RequestBody people: People):People{
        return peopleService.save(people)
    }

    @PutMapping
    fun update(@RequestBody people: People) : ResponseEntity<People> {
        return ResponseEntity ( peopleService.update(people), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody people: People) : ResponseEntity<People> {
        return ResponseEntity ( peopleService.updateName(people), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long):Boolean?{
        return peopleService.delete(id)
    }

}