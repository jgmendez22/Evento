package com.example.evento.service

import com.example.evento.model.People
import com.example.evento.repository.PeopleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class PeopleService {
    @Autowired
    lateinit var peopleRepository: PeopleRepository

    fun listById (id: Long?): People? {
        return peopleRepository.findById(id)
    }

    fun list(): List<People> {
        return peopleRepository.findAll()
    }

    fun save(people: People): People {
        return peopleRepository.save(people)
    }
    fun delete(id:Long?):Boolean?{
        peopleRepository.findById(id)?:
        throw Exception()
        peopleRepository.deleteById(id!!)
        return true
    }

    fun update(people: People): People {
        try {
            peopleRepository.findById(people.id)
                ?: throw Exception("Id existe")
            return peopleRepository.save(people)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun updateName(people: People): People {
        try {
            val response = peopleRepository.findById(people.id)
                ?: throw Exception("Id existe")
            response.apply {
                fullname= people.fullname
            }
            return peopleRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


}