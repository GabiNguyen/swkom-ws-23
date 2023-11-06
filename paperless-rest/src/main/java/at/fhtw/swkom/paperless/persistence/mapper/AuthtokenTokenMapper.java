package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.AuthtokenTokenDto;
import at.fhtw.swkom.paperless.persistence.model.AuthtokenToken;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class})
public interface AuthtokenTokenMapper {
    AuthtokenToken toEntity(AuthtokenTokenDto authtokenTokenDto);

    AuthtokenTokenDto toDto(AuthtokenToken authtokenToken);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuthtokenToken partialUpdate(AuthtokenTokenDto authtokenTokenDto, @MappingTarget AuthtokenToken authtokenToken);
}