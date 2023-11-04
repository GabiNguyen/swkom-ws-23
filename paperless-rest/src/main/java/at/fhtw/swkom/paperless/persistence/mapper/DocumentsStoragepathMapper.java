package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsStoragepathDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsStoragepath;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class})
public interface DocumentsStoragepathMapper {
    DocumentsStoragepath toEntity(DocumentsStoragepathDto documentsStoragepathDto);

    DocumentsStoragepathDto toDto(DocumentsStoragepath documentsStoragepath);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsStoragepath partialUpdate(DocumentsStoragepathDto documentsStoragepathDto, @MappingTarget DocumentsStoragepath documentsStoragepath);
}