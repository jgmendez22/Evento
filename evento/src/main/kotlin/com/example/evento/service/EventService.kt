package com.example.evento.service

import com.example.evento.model.Event
import com.example.evento.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class EventService {
    @Autowired
    lateinit var eventRepository: EventRepository

    fun listById (id: Long?): Event? {
        return eventRepository.findById(id)
    }

    fun list(): List<Event> {
        return eventRepository.findAll()
    }

    fun save(event: Event): Event {
        return eventRepository.save(event)
    }
    fun delete(id:Long?):Boolean?{
        eventRepository.findById(id)?:
        throw Exception()
        eventRepository.deleteById(id!!)
        return true
    }

    fun update(event: Event): Event {
        try {
            eventRepository.findById(event.id)
                ?: throw Exception("Id existe")
            return eventRepository.save(event)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun updateName(event: Event): Event {
        try {
            val response = eventRepository.findById(event.id)
                ?: throw Exception("Id ya existe")
            response.apply {
                fullname= event.fullname
            }
            return eventRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


}