package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentDto;
import at.fhtw.swkom.paperless.persistence.entity.Document;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentMapper {
    Document toEntity(DocumentDto documentDto);

    DocumentDto toDto(Document document);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Document partialUpdate(DocumentDto documentDto, @MappingTarget Document document);
}