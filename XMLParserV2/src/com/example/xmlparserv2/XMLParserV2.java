package com.example.xmlparserv2;

import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;

public class XMLParserV2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		XmlPullParserFactory pullParserFactory;
		try {
			pullParserFactory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = pullParserFactory.newPullParser();

			    InputStream in_s = getApplicationContext().getAssets().open("livro.xml");
		        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
	            parser.setInput(in_s, null);
	            parseXML(parser);

		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
        int eventType = parser.getEventType();
        boolean isP = false;
        String pastEndTag, paragraph, name;
        pastEndTag = "";
        paragraph = "";
        while (eventType != XmlPullParser.END_DOCUMENT){
            switch (eventType){
            	case XmlPullParser.START_TAG:
            		name = parser.getName();
                	if (name.equals("p")){
                		isP = true;
                		paragraph = "";
                	} else if (name.equals("pagenum")){
                		if (pastEndTag.equals("p")){
                			System.out.println(paragraph);
                		}
                	}
                	break;
            	case XmlPullParser.END_TAG:
            		name = parser.getName();
            		if (name.equalsIgnoreCase("p")){
            			isP = false;
            		}
            		pastEndTag = name;
            		break;
            	case XmlPullParser.TEXT:
            		if (isP){
            			paragraph += "\n" + parser.getText();
            		}
            		break;
            }
            eventType = parser.next();
        }
	}

}
