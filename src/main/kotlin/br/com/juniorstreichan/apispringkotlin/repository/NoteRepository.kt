package br.com.juniorstreichan.apispringkotlin.repository

import br.com.juniorstreichan.apispringkotlin.domain.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : JpaRepository<Note, Long> {

    fun findByTitle(tit:String):Note
}