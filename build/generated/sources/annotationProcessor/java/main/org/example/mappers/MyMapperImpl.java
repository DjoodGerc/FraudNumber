package org.example.mappers;

import javax.annotation.processing.Generated;
import org.example.repository.FraudDAO;
import org.example.repository.FraudEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-28T13:38:10+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class MyMapperImpl implements MyMapper {

    @Override
    public FraudEntity DAOToEntity(FraudDAO fraudDAO) {
        if ( fraudDAO == null ) {
            return null;
        }

        FraudEntity fraudEntity = new FraudEntity();

        fraudEntity.setId( fraudDAO.getId() );
        fraudEntity.setNumber( fraudDAO.getNumber() );
        fraudEntity.setFlagOfBlocking( fraudDAO.isFlagOfBlocking() );
        fraudEntity.setTimeOfBlocking( fraudDAO.getTimeOfBlocking() );

        return fraudEntity;
    }

    @Override
    public FraudDAO EntityToDAO(FraudEntity fraudEntity) {
        if ( fraudEntity == null ) {
            return null;
        }

        FraudDAO fraudDAO = new FraudDAO();

        fraudDAO.setId( fraudEntity.getId() );
        fraudDAO.setNumber( fraudEntity.getNumber() );
        fraudDAO.setFlagOfBlocking( fraudEntity.isFlagOfBlocking() );
        fraudDAO.setTimeOfBlocking( fraudEntity.getTimeOfBlocking() );

        return fraudDAO;
    }
}
