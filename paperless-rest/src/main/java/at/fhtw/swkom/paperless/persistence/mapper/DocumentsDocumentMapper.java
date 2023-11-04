package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsDocument;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DocumentsCorrespondentMapper.class, DocumentsDocumenttypeMapper.class, DocumentsStoragepathMapper.class, AuthUserMapper.class})
public interface DocumentsDocumentMapper {
    DocumentsDocument toEntity(DocumentsDocumentDto documentsDocumentDto);

    DocumentsDocumentDto toDto(DocumentsDocument documentsDocument);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsDocument partialUpdate(DocumentsDocumentDto documentsDocumentDto, @MappingTarget DocumentsDocument documentsDocument);
}