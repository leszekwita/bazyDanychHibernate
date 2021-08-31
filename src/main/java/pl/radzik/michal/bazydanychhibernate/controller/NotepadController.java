package pl.radzik.michal.bazydanychhibernate.controller;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radzik.michal.bazydanychhibernate.model.Notepad;
import pl.radzik.michal.bazydanychhibernate.service.NotepadService;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class NotepadController {

    private final NotepadService notepadService;

    @GetMapping("/notepads")
    public String getAllNotepads(Model model) {
        model.addAttribute("notepads", notepadService.getAllNotepads());
        model.addAttribute("newNotepad", new Notepad());
        return "notepads";
    }

    @PostMapping(value = "/newNotepad")
    public String addNotepad(@ModelAttribute("newNotepad") Notepad notepad) {
        notepadService.addNotepad(notepad);
        return "redirect:/notepads";
    }

    @PostMapping(value = "/updateNotepad")
    public String updateNotepad(@ModelAttribute("notepad") Notepad notepad) {

        Optional<Notepad> notepadFound = notepadService.getNotepadById(notepad.getId());
        if (notepadFound.isPresent()) {
            notepadService.removeNotePad(notepadFound.get());
            notepadService.addNotepad(notepad);
        }
        return "redirect:/notepads";
    }

    @GetMapping(value = "/id")
    public String getNotepadById(@ModelAttribute("id") String id, Model model) {

        model.addAttribute("id", id);
        Optional<Notepad> notepadFound = notepadService.getNotepadById(Integer.valueOf(id));

        if (notepadFound.isPresent()) {
            model.addAttribute("notepad", notepadFound.get());
        }
        return "updateNotepad";
    }
}
