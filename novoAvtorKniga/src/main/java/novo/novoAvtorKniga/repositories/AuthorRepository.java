package novo.novoAvtorKniga.repositories;

import novo.novoAvtorKniga.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
