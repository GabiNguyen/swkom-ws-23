package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.AuthPermissionDto;
import at.fhtw.swkom.paperless.persistence.model.AuthPermission;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthPermissionMapper {
    AuthPermission toEntity(AuthPermissionDto authPermissionDto);

    AuthPermissionDto toDto(AuthPermission authPermission);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuthPermission partialUpdate(AuthPermissionDto authPermissionDto, @MappingTarget AuthPermission authPermission);
}