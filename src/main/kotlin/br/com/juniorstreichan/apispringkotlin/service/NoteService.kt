package br.com.juniorstreichan.apispringkotlin.service

import br.com.juniorstreichan.apispringkotlin.domain.Note
import br.com.juniorstreichan.apispringkotlin.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NoteService {

    @Autowired
    private lateinit var repo: NoteRepository


    fun listNotes(): Collection<Note> = repo.findAll()

    fun exists(id: Long): Boolean = repo.existsById(id)

    fun insert(note: Note): Note = repo.save(note)

    fun update(note: Note): Note? = if(note.id>0) repo.save(note) else null
}