package converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import model.TipoUsuario;

@Converter(autoApply = true)
public class ConverterTipoUsuario implements AttributeConverter<TipoUsuario, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoUsuario tipoUsuario) {
		return tipoUsuario.getId();
	}

	@Override
	public TipoUsuario convertToEntityAttribute(Integer value) {
		if (value == null) 
			return null;
		return TipoUsuario.valueOf(value);
	}
}
