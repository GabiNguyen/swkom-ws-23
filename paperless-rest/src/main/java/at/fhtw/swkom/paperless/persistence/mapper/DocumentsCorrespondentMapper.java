package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsCorrespondentDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsCorrespondent;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class})
public interface DocumentsCorrespondentMapper {
    DocumentsCorrespondent toEntity(DocumentsCorrespondentDto documentsCorrespondentDto);

    DocumentsCorrespondentDto toDto(DocumentsCorrespondent documentsCorrespondent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsCorrespondent partialUpdate(DocumentsCorrespondentDto documentsCorrespondentDto, @MappingTarget DocumentsCorrespondent documentsCorrespondent);
}