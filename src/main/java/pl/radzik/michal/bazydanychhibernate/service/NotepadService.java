package pl.radzik.michal.bazydanychhibernate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.radzik.michal.bazydanychhibernate.model.Notepad;
import pl.radzik.michal.bazydanychhibernate.repository.NotepadRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class NotepadService {

    private  final NotepadRepository notepadRepository;

    public List<Notepad> getAllNotepads(){
        return notepadRepository.findAll();

    }
    public Notepad addNotepad(Notepad notepad){
        return notepadRepository.save(notepad);
    }

    public Optional<Notepad> getNotepadById(int id) {
        return notepadRepository.findById(id);
    }

    public void removeNotePad(Notepad notepad) {
        notepadRepository.delete(notepad);
    }

}
