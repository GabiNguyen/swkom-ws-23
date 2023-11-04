package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.DocumentsPaperlesstaskDto;
import at.fhtw.swkom.paperless.persistence.model.DocumentsPaperlesstask;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentsPaperlesstaskMapper {
    DocumentsPaperlesstask toEntity(DocumentsPaperlesstaskDto documentsPaperlesstaskDto);

    DocumentsPaperlesstaskDto toDto(DocumentsPaperlesstask documentsPaperlesstask);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentsPaperlesstask partialUpdate(DocumentsPaperlesstaskDto documentsPaperlesstaskDto, @MappingTarget DocumentsPaperlesstask documentsPaperlesstask);
}