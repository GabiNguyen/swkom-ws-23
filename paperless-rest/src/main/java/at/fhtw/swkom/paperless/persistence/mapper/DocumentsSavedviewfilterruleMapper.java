package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsSavedviewfilterruleDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsSavedviewfilterrule;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DocumentsSavedviewMapper.class})
public interface DocumentsSavedviewfilterruleMapper {
    DocumentsSavedviewfilterrule toEntity(DocumentsSavedviewfilterruleDto documentsSavedviewfilterruleDto);

    DocumentsSavedviewfilterruleDto toDto(DocumentsSavedviewfilterrule documentsSavedviewfilterrule);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsSavedviewfilterrule partialUpdate(DocumentsSavedviewfilterruleDto documentsSavedviewfilterruleDto, @MappingTarget DocumentsSavedviewfilterrule documentsSavedviewfilterrule);
}