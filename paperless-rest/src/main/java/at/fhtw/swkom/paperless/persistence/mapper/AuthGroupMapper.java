package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.AuthGroupDto;
import at.fhtw.swkom.paperless.persistence.model.AuthGroup;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthGroupMapper {
    AuthGroup toEntity(AuthGroupDto authGroupDto);

    AuthGroupDto toDto(AuthGroup authGroup);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuthGroup partialUpdate(AuthGroupDto authGroupDto, @MappingTarget AuthGroup authGroup);
}