package br.com.juniorstreichan.apispringkotlin.service

import br.com.juniorstreichan.apispringkotlin.domain.Note
import br.com.juniorstreichan.apispringkotlin.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NoteService {

    @Autowired
    private lateinit var repo: NoteRepository


    fun getNotes(): Collection<Note> {
        return repo.findAll()
    }

    fun insert(note:Note):Note{
        return repo.save(note)
    }
}