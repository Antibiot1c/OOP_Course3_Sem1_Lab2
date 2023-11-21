import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GemSAXHandler extends DefaultHandler {
    private List<Gem> gems = new ArrayList<>();
    private Gem gem;
    private VisualParameters visualParameters;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if ("Gem".equals(currentElement)) {
            gem = new Gem();
        }
        if ("VisualParameters".equals(currentElement)) {
            visualParameters = new VisualParameters();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (currentElement != null) {
            switch (currentElement) {
                case "Name":
                    gem.setName(value);
                    break;
                case "Preciousness":
                    gem.setPreciousness(value);
                    break;
                case "Origin":
                    gem.setOrigin(value);
                    break;
                case "Color":
                    visualParameters.setColor(value);
                    break;
                case "Transparency":
                    visualParameters.setTransparency(new BigDecimal(value));
                    break;
                case "Facets":
                    visualParameters.setFacets(Integer.parseInt(value));
                    break;
                case "Value":
                    gem.setValue(new BigDecimal(value));
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("Gem".equals(qName)) {
            gem.setVisualParameters(visualParameters);
            gems.add(gem);
            gem = null;
            visualParameters = null;
        }
    }

    public List<Gem> getGems() {
        return gems;
    }
}
