package idusw.springboot.hshblog.repository;

import idusw.springboot.hshblog.entity.BlogEntity;
import idusw.springboot.hshblog.model.BlogDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogEntity, Long> {
    Optional<BlogEntity> findByIdx(BlogDto dto); // interface 상속,
}
