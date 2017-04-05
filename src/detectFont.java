import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.text.TextPosition;

import java.io.*;
import java.lang.*;
import java.util.*;
import org.apache.pdfbox.text.PDFTextStripper;

public class detectFont{
	public static boolean allparams;
	public static void main(String args[]){
		String filename = null;
		detectFont.allparams = false;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("--file")||args[i].equals("-f")){
				
				filename = args[++i];
				
			}
			if (args[i].equals("--allparams")||args[i].equals("-a")){
				detectFont.allparams = Boolean.parseBoolean(args[++i]);
			}
		}
		if(filename==null){
			System.out.println("Please provide a filename to proceed.");
		}
		try{
			System.out.println(filename);
			File file = new File(filename);
			PDDocument  doc = PDDocument.load(file);
			PDFTextStripper pdfStripper = new PDFTextStripper(){
				String prevBaseFont = "";
				float prevFontWeight=0;
				
			    protected void writeString(String text, List<TextPosition> textPositions) throws IOException
			    {
			        StringBuilder builder = new StringBuilder();
	
			        for (TextPosition position : textPositions)
			        {
			            String baseFont = position.getFont().getName();
			            String subTypeFont = position.getFont().getSubType();
			            String fontFamily = position.getFont().getFontDescriptor().getFontFamily();
			            float fontSize = position.getFontSize();
			            float fontWeight = position.getFont().getFontDescriptor().getFontWeight();
			            
			            if (baseFont!=null && !baseFont.equals(prevBaseFont) && fontWeight!=prevFontWeight){
			            	builder.append("[Font Name:").append(baseFont).append(',');
				            builder.append("Font Subtype:").append(subTypeFont).append(',');
				            builder.append("Font Family:").append(fontFamily).append(',');
			                builder.append("Font Size:").append(fontSize).append(',');
			                builder.append("Font Weight:").append(fontWeight);
			                if (detectFont.allparams==true){
			                	boolean isAllCap = position.getFont().getFontDescriptor().isAllCap();
					            boolean isForceBold = position.getFont().getFontDescriptor().isForceBold();
					            boolean isItalic = position.getFont().getFontDescriptor().isItalic();
					            boolean isScript = position.getFont().getFontDescriptor().isScript();
					            boolean isSerif = position.getFont().getFontDescriptor().isSerif();
					            boolean isSmallCap = position.getFont().getFontDescriptor().isSmallCap();
			                	builder.append(',').append("Is All Cap:").append(isAllCap).append(',');
				                builder.append("Is Force Bold:").append(isForceBold).append(',');
				                builder.append("Is Italic:").append(isItalic).append(',');
				                builder.append("Is Script:").append(isScript).append(',');
				                builder.append("Is Serif:").append(isSerif).append(',');
				                builder.append("Is Small Cap:").append(isSmallCap).append(',');
				                builder.append("Font Size:").append(fontSize);
			                }
			                builder.append(']');
				            
				            prevBaseFont = baseFont;
				            prevFontWeight = fontWeight;
				            
			            }
			            builder.append(position.toString());
			        }
	
			        writeString(builder.toString());
			    }
			};
			String text = pdfStripper.getText(doc);
			
		    System.out.println(text);
			      //Closing the document
			doc.close();
		}
		catch(Exception ex)
        {
			ex.printStackTrace();
        }

	}
}

