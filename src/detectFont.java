import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.text.TextPosition;

import java.io.*;
import java.util.*;
import org.apache.pdfbox.text.PDFTextStripper;

public class detectFont{
	public static void main(String args[]){
		String filename = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("--file")||args[i].equals("-f")){
				
				filename = args[++i];
				
			}
		}
		if(filename==null){
			System.out.println("Please provide a filename to proceed.");
		}
		try{
			//File file = new File("C:/Users/Ankit/Desktop/College/BTP/btp_2015.pdf");
			System.out.println(filename);
			File file = new File(filename);
			PDDocument  doc = PDDocument.load(file);
			PDFTextStripper pdfStripper = new PDFTextStripper(){
				String prevBaseFont = "";
	
			    protected void writeString(String text, List<TextPosition> textPositions) throws IOException
			    {
			        StringBuilder builder = new StringBuilder();
	
			        for (TextPosition position : textPositions)
			        {
			            String baseFont = position.getFont().getName();
			            if (baseFont != null && !baseFont.equals(prevBaseFont))
			            {
			                builder.append('[').append(baseFont).append(']');
			                prevBaseFont = baseFont;
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

