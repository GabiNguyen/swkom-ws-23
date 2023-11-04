package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.AuthUserUserPermissionDto;
import at.fhtw.swkom.paperless.persistence.model.AuthUserUserPermission;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class, AuthPermissionMapper.class})
public interface AuthUserUserPermissionMapper {
    AuthUserUserPermission toEntity(AuthUserUserPermissionDto authUserUserPermissionDto);

    AuthUserUserPermissionDto toDto(AuthUserUserPermission authUserUserPermission);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuthUserUserPermission partialUpdate(AuthUserUserPermissionDto authUserUserPermissionDto, @MappingTarget AuthUserUserPermission authUserUserPermission);
}