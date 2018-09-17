package seba0.javaszc4.hotel.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seba0.javaszc4.hotel.server.model.entity.Information;
import seba0.javaszc4.hotel.server.model.repository.InformationRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationRepository informationRepository;

    @Override
    public List<Information> getAllInformations() {
        return (List<Information>) informationRepository.findAll();
    }

    @Override
    public Optional<Information> getInformationById(long id) {
        return informationRepository.findById(id);
    }

    @Override
    public void saveOrUpdateInformation(Information guest) {
        informationRepository.save(guest);
    }

    @Override
    public void deleteInformation(Information guest) {
        informationRepository.delete(guest);
    }
}
