import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxPersonParser {

    private static SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

    public List<Person> parse(String path) throws IOException, SAXException, ParserConfigurationException {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        Handler handler = new Handler();
        saxParser.parse(path, handler);
        return handler.getPersons();
    }
}
