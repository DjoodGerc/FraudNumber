package org.example.mappers;

import org.example.repository.FraudEntity;
import org.example.repository.FraudDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyMapper {
    FraudEntity DAOToEntity(FraudDAO fraudDAO);
    FraudDAO EntityToDAO(FraudEntity fraudEntity);
}
