package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.PaperlessMailProcessedmailDto;
import at.fhtw.swkom.paperless.persistence.model.PaperlessMailProcessedmail;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class, PaperlessMailMailruleMapper.class})
public interface PaperlessMailProcessedmailMapper {
    PaperlessMailProcessedmail toEntity(PaperlessMailProcessedmailDto paperlessMailProcessedmailDto);

    PaperlessMailProcessedmailDto toDto(PaperlessMailProcessedmail paperlessMailProcessedmail);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PaperlessMailProcessedmail partialUpdate(PaperlessMailProcessedmailDto paperlessMailProcessedmailDto, @MappingTarget PaperlessMailProcessedmail paperlessMailProcessedmail);
}