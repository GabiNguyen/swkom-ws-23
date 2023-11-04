package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsDocumenttypeDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsDocumenttype;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class})
public interface DocumentsDocumenttypeMapper {
    DocumentsDocumenttype toEntity(DocumentsDocumenttypeDto documentsDocumenttypeDto);

    DocumentsDocumenttypeDto toDto(DocumentsDocumenttype documentsDocumenttype);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsDocumenttype partialUpdate(DocumentsDocumenttypeDto documentsDocumenttypeDto, @MappingTarget DocumentsDocumenttype documentsDocumenttype);
}