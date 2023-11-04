package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.PaperlessMailMailruleDto;
import at.fhtw.swkom.paperless.persistence.model.PaperlessMailMailrule;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {PaperlessMailMailaccountMapper.class, DocumentsCorrespondentMapper.class, DocumentsDocumenttypeMapper.class, AuthUserMapper.class})
public interface PaperlessMailMailruleMapper {
    PaperlessMailMailrule toEntity(PaperlessMailMailruleDto paperlessMailMailruleDto);

    PaperlessMailMailruleDto toDto(PaperlessMailMailrule paperlessMailMailrule);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PaperlessMailMailrule partialUpdate(PaperlessMailMailruleDto paperlessMailMailruleDto, @MappingTarget PaperlessMailMailrule paperlessMailMailrule);
}