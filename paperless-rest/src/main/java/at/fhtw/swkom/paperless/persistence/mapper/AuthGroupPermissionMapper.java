package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.AuthGroupPermissionDto;
import at.fhtw.swkom.paperless.persistence.model.AuthGroupPermission;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthGroupMapper.class, AuthPermissionMapper.class})
public interface AuthGroupPermissionMapper {
    AuthGroupPermission toEntity(AuthGroupPermissionDto authGroupPermissionDto);

    AuthGroupPermissionDto toDto(AuthGroupPermission authGroupPermission);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuthGroupPermission partialUpdate(AuthGroupPermissionDto authGroupPermissionDto, @MappingTarget AuthGroupPermission authGroupPermission);
}