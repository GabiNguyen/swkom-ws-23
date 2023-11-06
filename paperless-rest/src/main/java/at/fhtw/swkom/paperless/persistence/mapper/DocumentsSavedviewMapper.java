package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsSavedviewDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsSavedview;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class})
public interface DocumentsSavedviewMapper {
    DocumentsSavedview toEntity(DocumentsSavedviewDto documentsSavedviewDto);

    DocumentsSavedviewDto toDto(DocumentsSavedview documentsSavedview);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsSavedview partialUpdate(DocumentsSavedviewDto documentsSavedviewDto, @MappingTarget DocumentsSavedview documentsSavedview);
}