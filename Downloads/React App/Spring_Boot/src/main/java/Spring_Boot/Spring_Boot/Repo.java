package Spring_Boot.Spring_Boot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Student,Integer> {
    
}
