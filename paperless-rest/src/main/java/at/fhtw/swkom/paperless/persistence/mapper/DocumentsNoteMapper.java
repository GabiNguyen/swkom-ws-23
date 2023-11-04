package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsNoteDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsNote;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DocumentsDocumentMapper.class, AuthUserMapper.class})
public interface DocumentsNoteMapper {
    DocumentsNote toEntity(DocumentsNoteDto documentsNoteDto);

    DocumentsNoteDto toDto(DocumentsNote documentsNote);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsNote partialUpdate(DocumentsNoteDto documentsNoteDto, @MappingTarget DocumentsNote documentsNote);
}