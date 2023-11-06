package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsDocumentTagDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsDocumentTag;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DocumentsDocumentMapper.class, DocumentsTagMapper.class})
public interface DocumentsDocumentTagMapper {
    DocumentsDocumentTag toEntity(DocumentsDocumentTagDto documentsDocumentTagDto);

    DocumentsDocumentTagDto toDto(DocumentsDocumentTag documentsDocumentTag);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsDocumentTag partialUpdate(DocumentsDocumentTagDto documentsDocumentTagDto, @MappingTarget DocumentsDocumentTag documentsDocumentTag);
}