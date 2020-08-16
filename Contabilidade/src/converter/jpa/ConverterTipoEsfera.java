package converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import model.TipoEsfera;

@Converter(autoApply = true)
public class ConverterTipoEsfera implements AttributeConverter<TipoEsfera, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoEsfera tipoEsfera) {
		return tipoEsfera.getId();
	}

	@Override
	public TipoEsfera convertToEntityAttribute(Integer value) {
		if (value == null) 
			return null;
		return TipoEsfera.valueOf(value);
	}
}
