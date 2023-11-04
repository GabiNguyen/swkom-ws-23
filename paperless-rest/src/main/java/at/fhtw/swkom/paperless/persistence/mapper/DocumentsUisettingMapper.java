package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsUisettingDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsUisetting;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class})
public interface DocumentsUisettingMapper {
    DocumentsUisetting toEntity(DocumentsUisettingDto documentsUisettingDto);

    DocumentsUisettingDto toDto(DocumentsUisetting documentsUisetting);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsUisetting partialUpdate(DocumentsUisettingDto documentsUisettingDto, @MappingTarget DocumentsUisetting documentsUisetting);
}