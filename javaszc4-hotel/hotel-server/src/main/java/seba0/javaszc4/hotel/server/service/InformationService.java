package seba0.javaszc4.hotel.server.service;

import seba0.javaszc4.hotel.server.model.entity.Information;

import java.util.List;
import java.util.Optional;

public interface InformationService {

    List<Information> getAllInformations();

    Optional<Information> getInformationById(long id);

    void saveOrUpdateInformation(Information information);

    void deleteInformation(Information information);

}
