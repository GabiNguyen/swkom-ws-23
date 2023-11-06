package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.PaperlessMailMailruleAssignTagDto;
import at.fhtw.swkom.paperless.persistence.model.PaperlessMailMailruleAssignTag;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {PaperlessMailMailruleMapper.class, DocumentsTagMapper.class})
public interface PaperlessMailMailruleAssignTagMapper {
    PaperlessMailMailruleAssignTag toEntity(PaperlessMailMailruleAssignTagDto paperlessMailMailruleAssignTagDto);

    PaperlessMailMailruleAssignTagDto toDto(PaperlessMailMailruleAssignTag paperlessMailMailruleAssignTag);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PaperlessMailMailruleAssignTag partialUpdate(PaperlessMailMailruleAssignTagDto paperlessMailMailruleAssignTagDto, @MappingTarget PaperlessMailMailruleAssignTag paperlessMailMailruleAssignTag);
}