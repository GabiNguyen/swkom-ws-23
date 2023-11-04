package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsLogDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsLog;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentsLogMapper {
    DocumentsLog toEntity(DocumentsLogDto documentsLogDto);

    DocumentsLogDto toDto(DocumentsLog documentsLog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsLog partialUpdate(DocumentsLogDto documentsLogDto, @MappingTarget DocumentsLog documentsLog);
}