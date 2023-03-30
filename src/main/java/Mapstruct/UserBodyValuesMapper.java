package Mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserBodyValuesMapper {
    UserBodyValuesMapper INSTANCE= Mappers.getMapper(UserBodyValuesMapper.class);

    @Mapping(source = "inch", target = "centimeter", qualifiedByName="inchToCentimeter")
    public UserBodyValues userBodyValuesMapper(UserBodyImperialValuesDTO dto);

    @Named("inchToCentimeter")
    public static double inchToCentimeter(int inch) {
        return inch * 2.54;
    }
}
