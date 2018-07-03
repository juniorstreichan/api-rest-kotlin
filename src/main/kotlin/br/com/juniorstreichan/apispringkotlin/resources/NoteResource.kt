package br.com.juniorstreichan.apispringkotlin.resources

import br.com.juniorstreichan.apispringkotlin.domain.Note
import br.com.juniorstreichan.apispringkotlin.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


@RestController
@RequestMapping(value = "notes")
class NoteResource {
    @Autowired
    lateinit var service: NoteService

    @GetMapping
    fun list(): ResponseEntity<Collection<Note>> {

        val lista = service.listNotes()
        return ResponseEntity.ok().body(lista)
    }

    @PostMapping
    fun add(@RequestBody note: Note): ResponseEntity<Note> {
        val newNote = service.insert(note)

        return ResponseEntity.created(
                URI(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newNote.id).toUriString())
        ).body(newNote)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody note: Note): ResponseEntity<Note> {
        if (service.exists(id)) {
            val newNote = service.update(Note(id,note.title,note.description))
            return ResponseEntity.ok().body(newNote) //TODO mudar depois
        }
        return ResponseEntity.notFound().build()
    }
}