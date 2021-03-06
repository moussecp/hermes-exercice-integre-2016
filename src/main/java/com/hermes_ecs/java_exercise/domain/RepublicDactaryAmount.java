package com.hermes_ecs.java_exercise.domain;

import java.text.DecimalFormat;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class RepublicDactaryAmount {

	public static final String SYMBOL = "||7";
    private static final int REPRESENTATION_BEGIN = 0;

    private float value;

	protected RepublicDactaryAmount() {}
	
	public RepublicDactaryAmount(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("price.invalid");
		}
		this.value = convert(value);
	}

	public float getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(value).toHashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof RepublicDactaryAmount) {
			RepublicDactaryAmount otherNumber = (RepublicDactaryAmount) other;
			return new EqualsBuilder().append(getValue(), otherNumber.getValue()).isEquals();
		}
		else {
			return false;
		}
	}
	
	public String getValueForDisplay() {
		return new DecimalFormat("#.##").format(value) + " "+SYMBOL;
	}

	@Override
	public String toString() {
		return getValueForDisplay();
	}

	private static float convert(String value) {
        final String priceWithoutSymbol = trimPriceSymbolIfNeeded(value);
        return convertToFloat(priceWithoutSymbol);
    }

    public static boolean isValid(String price) {
        if (StringUtils.isEmpty(price)) {
            return false;
        }

        final String priceWithoutSymbol = trimPriceSymbolIfNeeded(price);

        return isValidFloat(priceWithoutSymbol);
    }

    private static String trimPriceSymbolIfNeeded(String priceRepresentation) {
        if (priceRepresentation.endsWith(SYMBOL)) {
            return trimPriceSymbol(priceRepresentation);
        } else {
            return priceRepresentation;
        }
    }

    private static String trimPriceSymbol(String priceRepresentationWithSymbol) {
        final int representationLengthWithoutSymbol = priceRepresentationWithSymbol.length() - SYMBOL.length();
        return priceRepresentationWithSymbol.substring(REPRESENTATION_BEGIN, representationLengthWithoutSymbol);
    }

    private static boolean isValidFloat(String floatRepresentation) {
        try {
            convertToFloat(floatRepresentation);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    private static Float convertToFloat(String floatRepresentation) {
        return new Float(convertCommaToDot(floatRepresentation));
    }

    private static String convertCommaToDot(String string) {
        return string.replace(',', '.');
    }

}
