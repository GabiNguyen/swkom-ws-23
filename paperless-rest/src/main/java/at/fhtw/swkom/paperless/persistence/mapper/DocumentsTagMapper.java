package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsTagDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsTag;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class})
public interface DocumentsTagMapper {
    DocumentsTag toEntity(DocumentsTagDto documentsTagDto);

    DocumentsTagDto toDto(DocumentsTag documentsTag);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsTag partialUpdate(DocumentsTagDto documentsTagDto, @MappingTarget DocumentsTag documentsTag);
}