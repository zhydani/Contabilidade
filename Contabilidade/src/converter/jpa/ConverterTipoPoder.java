package converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import model.TipoPoder;

@Converter(autoApply = true)
public class ConverterTipoPoder implements AttributeConverter<TipoPoder, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoPoder tipoPoder) {
		return tipoPoder.getId();
	}

	@Override
	public TipoPoder convertToEntityAttribute(Integer value) {
		if (value == null) 
			return null;
		return TipoPoder.valueOf(value);
	}
}
