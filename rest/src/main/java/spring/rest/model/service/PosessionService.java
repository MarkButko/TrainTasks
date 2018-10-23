package spring.rest.model.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.rest.model.dao.PosessionRepository;
import spring.rest.model.entity.Posession;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PosessionService {

    private PosessionRepository PosessionRepository;

    @Transactional
    public Posession save(Posession Posession){
        return PosessionRepository.save(Posession);
    }

    @Transactional(readOnly=true)
    public Optional<Posession> findById(Long id){
        return PosessionRepository.findById(id);
    }

    @Transactional(readOnly=true)
    public List<Posession> findAll() {
        return  PosessionRepository.findAll();
    }

    @Transactional
    public  void deleteById(Long id) {
        PosessionRepository.deleteById(id);
    }

    @Transactional
    public void delete(Posession Posession) {
        PosessionRepository.delete(Posession);
    }

    @Transactional
    public  void deleteAll() {
        PosessionRepository.deleteAll();
    }
}
