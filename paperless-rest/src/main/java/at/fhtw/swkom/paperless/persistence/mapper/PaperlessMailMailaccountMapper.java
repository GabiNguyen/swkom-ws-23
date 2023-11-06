package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.PaperlessMailMailaccountDto;
import at.fhtw.swkom.paperless.persistence.model.PaperlessMailMailaccount;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class})
public interface PaperlessMailMailaccountMapper {
    PaperlessMailMailaccount toEntity(PaperlessMailMailaccountDto paperlessMailMailaccountDto);

    PaperlessMailMailaccountDto toDto(PaperlessMailMailaccount paperlessMailMailaccount);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PaperlessMailMailaccount partialUpdate(PaperlessMailMailaccountDto paperlessMailMailaccountDto, @MappingTarget PaperlessMailMailaccount paperlessMailMailaccount);
}