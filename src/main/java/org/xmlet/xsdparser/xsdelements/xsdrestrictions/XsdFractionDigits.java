package org.xmlet.xsdparser.xsdelements.xsdrestrictions;

import org.xmlet.xsdparser.core.XsdParserCore;
import org.xmlet.xsdparser.core.utils.ParseData;
import org.xmlet.xsdparser.xsdelements.AttributeValidations;
import org.xmlet.xsdparser.xsdelements.XsdAbstractElement;
import org.xmlet.xsdparser.xsdelements.elementswrapper.ReferenceBase;
import org.xmlet.xsdparser.xsdelements.visitors.XsdAbstractElementVisitor;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.function.Function;

/**
 * States the number of fraction digits allowed in a numeric type. The value is defined as an {@link Integer}.
 */
public class XsdFractionDigits extends XsdIntegerRestrictions {

    public static final String XSD_TAG = "xsd:fractionDigits";
    public static final String XS_TAG = "xs:fractionDigits";

    private XsdFractionDigits(@NotNull XsdParserCore parser, @NotNull Map<String, String> elementFieldsMapParam, @NotNull Function<XsdAbstractElement, XsdAbstractElementVisitor> visitorFunction) {
        super(parser, elementFieldsMapParam, visitorFunction);

        value = AttributeValidations.validateRequiredNonNegativeInteger(XSD_TAG, VALUE_TAG, attributesMap.get(VALUE_TAG));
    }

    @Override
    public void accept(XsdAbstractElementVisitor xsdAbstractElementVisitor) {
        super.accept(xsdAbstractElementVisitor);
        xsdAbstractElementVisitor.visit(this);
    }

    public static ReferenceBase parse(@NotNull ParseData parseData){
        return ReferenceBase.createFromXsd(new XsdFractionDigits(parseData.parserInstance, convertNodeMap(parseData.node.getAttributes()), parseData.visitorFunction));
    }
}
