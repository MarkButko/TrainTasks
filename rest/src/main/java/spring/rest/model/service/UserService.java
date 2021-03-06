package spring.rest.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.rest.model.dao.UserRepository;
import spring.rest.model.entity.User;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
        System.out.println("UserService");
    }

    @Transactional
    public User saveOrUpdate(User User){
        System.out.println("UserRepository = " + userRepository);
         return userRepository.save(User);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return  userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Long id) {
        return  userRepository.existsById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public  void delete(User User) {
        userRepository.delete(User);
    }

    @Transactional
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
