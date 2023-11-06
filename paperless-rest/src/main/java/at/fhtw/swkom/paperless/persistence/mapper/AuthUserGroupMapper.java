package at.fhtw.swkom.paperless.persistence.mapper;

import at.fhtw.swkom.paperless.persistence.dto.AuthUserGroupDto;
import at.fhtw.swkom.paperless.persistence.model.AuthUserGroup;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthUserMapper.class, AuthGroupMapper.class})
public interface AuthUserGroupMapper {
    AuthUserGroup toEntity(AuthUserGroupDto authUserGroupDto);

    AuthUserGroupDto toDto(AuthUserGroup authUserGroup);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuthUserGroup partialUpdate(AuthUserGroupDto authUserGroupDto, @MappingTarget AuthUserGroup authUserGroup);
}