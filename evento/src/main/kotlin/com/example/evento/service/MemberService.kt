package com.example.evento.service

import com.example.evento.model.Member
import com.example.evento.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class MemberService {
    @Autowired
    lateinit var memberRepository: MemberRepository

    fun listById (id: Long?): Member? {
        return memberRepository.findById(id)
    }

    fun list(): List<Member> {
        return memberRepository.findAll()
    }

    fun save(member: Member): Member {
        return memberRepository.save(member)
    }
    fun delete(id:Long?):Boolean?{
        memberRepository.findById(id)?:
        throw Exception()
        memberRepository.deleteById(id!!)
        return true
    }

    fun update(member: Member): Member {
        try {
            memberRepository.findById(member.id)
                ?: throw Exception("Id existe")
            return memberRepository.save(member)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun updateName(member: Member): Member {
        try {
            val response = memberRepository.findById(member.id)
                ?: throw Exception("Id existente :v")
            response.apply {
                fullname= member.fullname
            }
            return memberRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


}