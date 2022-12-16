package com.example.evento.controller

import com.example.evento.model.Event
import com.example.evento.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/event")
class EventController {
    @Autowired
    lateinit var eventService: EventService
    @GetMapping("/{id}")

    fun listById (@PathVariable("id") id: Long): ResponseEntity<Event> {
        return ResponseEntity(eventService.listById(id), HttpStatus.OK)
    }

    @GetMapping
    fun list():List<Event>{
        return eventService.list()
    }

    @PostMapping
    fun save(@RequestBody event: Event):Event{
        return eventService.save(event)
    }

    @PutMapping
    fun update(@RequestBody event: Event) : ResponseEntity<Event> {
        return ResponseEntity ( eventService.update(event), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody event: Event) : ResponseEntity<Event> {
        return ResponseEntity ( eventService.updateName(event), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long):Boolean?{
        return eventService.delete(id)
    }

}