package spring.rest.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.rest.model.dao.PosessionRepository;
import spring.rest.model.entity.Posession;

import java.util.List;
import java.util.Optional;

@Transactional
public class PosessionService {

    @Autowired
    private PosessionRepository posessionRepository;

    @Transactional
    public Posession save(Posession posession){
        return posessionRepository.save(posession);
    }

    @Transactional(readOnly=true)
    public Optional<Posession> findById(Long id){
        return posessionRepository.findById(id);
    }

    @Transactional(readOnly=true)
    public List<Posession> findAll() {
        return  posessionRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<Posession> findAllByUserId(Long userId) {
        return  posessionRepository.findByUserId(userId);
    }

    @Transactional
    public  void deleteById(Long id) {
        posessionRepository.deleteById(id);
    }

    @Transactional
    public void delete(Posession Posession) {
        posessionRepository.delete(Posession);
    }

    @Transactional
    public  void deleteAll() {
        posessionRepository.deleteAll();
    }
}
