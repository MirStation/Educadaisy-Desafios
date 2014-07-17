package com.example.xmlparserv11;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.example.xmlparserv11.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class XMLParserV11 extends Activity {

	private TextView display;
	private ArrayList<String> paragraphsList = new ArrayList<String>();
	private int eventType;
	private String auxParagraphs = "";
	private int numParagraphs = 0;
	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.display_paragraphs);
//		this.display = (TextView) findViewById(R.id.paragraphsTextView);
//		XmlPullParserFactory pullParserFactory;
//		try {
//			pullParserFactory = XmlPullParserFactory.newInstance();
//			XmlPullParser parser = pullParserFactory.newPullParser();
//
//			InputStream in_s = getApplicationContext().getAssets().open(
//					"livro.xml");
//			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//			parser.setInput(in_s, null);
//			parseXML(parser);
//
//		} catch (XmlPullParserException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// displayParagraphs();
//		displayParagraphBlock();
//	}

//	private void parseXML(XmlPullParser parser) throws XmlPullParserException,
//			IOException {
//		int numParagraphs = 0;
//		int paragraphPackageSize = 3;
//		int eventType = parser.getEventType();
//		boolean isP = false;
//		String text;
//		String auxParagraphs = "";
//		while (eventType != XmlPullParser.END_DOCUMENT) {
//			switch (eventType) {
//			case XmlPullParser.START_TAG:
//				if (parser.getName().equals("p")) {
//					isP = true;
//					numParagraphs++;
//				}
//				break;
//			case XmlPullParser.END_TAG:
//				if (parser.getName().equals("p")) {
//					isP = false;
//				}
//				break;
//			case XmlPullParser.TEXT:
//				if (isP) {
//					text = parser.getText();
//					if (text != null && !text.isEmpty()
//							&& !text.trim().isEmpty()) {
//						if (numParagraphs <= paragraphPackageSize) {
//							auxParagraphs += text + "\n";
//						} else {
//							System.out.println(auxParagraphs);
//							paragraphsList.add(auxParagraphs);
//							auxParagraphs = text + "\n";
//							numParagraphs = 1;
//						}
//					} else {
//						numParagraphs--;
//					}
//				}
//				break;
//			}
//			eventType = parser.next();
//		}
//	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_paragraphs);
		this.display = (TextView) findViewById(R.id.paragraphsTextView);
		loadParagraphsBlock();
		loadParagraphsBlock();
		loadParagraphsBlock();
	}
	
	public void loadParagraphsBlock() {
		XmlPullParserFactory pullParserFactory;
		try {
			pullParserFactory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = pullParserFactory.newPullParser();

			InputStream in_s = getApplicationContext().getAssets().open(
					"livro.xml");
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(in_s, null);
			eventType = parser.getEventType();
			processXML(parser, 3);
			//processXML(parser, 3);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displayParagraphBlock();
		//displayParagraphBlock();
	}
	
	public void processXML(XmlPullParser parser, int paragraphPackageSize) throws XmlPullParserException,
			IOException {
		
		boolean isP = false;
		String text;
		eventType = parser.next();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
			case XmlPullParser.START_TAG:
				if (parser.getName().equals("p")) {
					isP = true;
					numParagraphs++;
				}
				break;
			case XmlPullParser.END_TAG:
				if (parser.getName().equals("p")) {
					isP = false;
				}
				break;
			case XmlPullParser.TEXT:
				if (isP) {
					text = parser.getText();
					if (text != null && !text.isEmpty()
							&& !text.trim().isEmpty()) {
						if (numParagraphs <= paragraphPackageSize) {
							auxParagraphs += text + "\n";
						} else {
							//System.out.println(auxParagraphs);
							paragraphsList.add(auxParagraphs);
							auxParagraphs = "<-->\n" + text + "\n";
							numParagraphs = 1;
						}
					} else {
						numParagraphs--;
					}
				}
				break;
			}
			eventType = parser.next();
		}
	}

	// private void displayParagraphs() {
	// TextView display = (TextView) findViewById(R.id.paragraphsTextView);
	// display.setText(paragraphs);
	// }

	public void displayParagraphBlock() {
		System.out.println("pls:" + paragraphsList.size());
		if (paragraphsList.size() > 0) {
			display.append(paragraphsList.remove(0));
		}
	}

}
