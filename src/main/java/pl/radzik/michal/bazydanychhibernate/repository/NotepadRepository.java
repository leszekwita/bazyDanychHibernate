package pl.radzik.michal.bazydanychhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.radzik.michal.bazydanychhibernate.model.Notepad;

@Repository
public interface NotepadRepository extends JpaRepository<Notepad, Integer> {
}
