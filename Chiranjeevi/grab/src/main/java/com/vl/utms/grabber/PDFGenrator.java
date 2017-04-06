package com.vl.utms.grabber;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.parser.PdfImageObject;

public class PDFGenrator {

	 public static void main(String[] args) throws DocumentException, IOException {
	        String fileName = "/home/chiranjeevi/Desktop/practice/x";
	        String rootPath = "/home/chiranjeevi/Downloads";

	       /* try {

	            PDDocument doc = new PDDocument();	            

	            List<File> files = Arrays.asList(new File("/home/chiranjeevi/Desktop/practiceSelenium/independent test configuration/080116/").listFiles());
	            for (File file : files) {
	            	PDPage page = new PDPage();
	            	System.out.println(file.getName());
		            doc.addPage(page);
		            PDImageXObject pdImage = PDImageXObject.createFromFile(file.getAbsolutePath(), doc);

		            PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, true);
		            float scale = 0.64f;
		            //contentStream.drawImage(pdImage, 10, 100, pdImage.getWidth()*scale, pdImage.getHeight()*scale);
		            contentStream.drawImage(pdImage, 20, 20);

		            contentStream.close();
				}
	            doc.save(fileName);

	            //doc.save(fileName);

	            doc.close();

	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	        }*/
	        
			    Document document = new Document();
			    document.compress = true;
			    createDir(fileName);
			    
			    FileOutputStream temp = new FileOutputStream(fileName + "/pdfWithImae.pdf");
			    
			    PdfWriter writer = PdfWriter.getInstance(document, temp);
			    File f = new File(fileName + "/pdfWithImae.pdf");
			    f.setExecutable(true, false);
			    f.setReadable(true, false);
			    f.setWritable(true, false);
			    System.out.println("Output Stream : " + writer.getOs());
			    HeaderFooterPageEvent event = new HeaderFooterPageEvent();
			    writer.setPageEvent(event);
			    
			    document.open();
			    float[] columnWidths = {2,5};
			    PdfPTable table = new PdfPTable(columnWidths);
		        // the cell object
		        PdfPCell cell;
		        // we add a cell with colspan 3
		        //Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GREEN);
		        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		        cell = new PdfPCell(new Phrase("Test Case Details", font));
		        cell.setBackgroundColor(BaseColor.GRAY);
		        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell.setColspan(2);
		        cell.setPadding(10);
		        table.addCell(cell);
		        // now we add a cell with rowspan 2
		        font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC);
		        cell = new PdfPCell(new Phrase("Cell with rowspan 2", font));
		        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		        cell.setPadding(8);
		        //cell.set
		        table.addCell(cell);
		        // we add the four remaining cells with addCell()
		        table.addCell("row 1; cell 1");
		        table.addCell("row 1; cell 2");
		        table.setHorizontalAlignment(Element.ALIGN_CENTER);
		        document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n"));
		        document.add(table);
			    Paragraph footer = new Paragraph("Sample 1: This is simple image demo.");
			    footer.setAlignment(Element.ALIGN_CENTER);
			    document.add(footer);
			    Arrays.asList(new File(rootPath).listFiles()).stream().filter(p->p.getPath().endsWith(".png")).forEach(file -> {
			    	try {
			    		document.newPage();			    		
			    		//document.add(new Paragraph("\n"));
						BufferedImage bufImg = ImageIO.read(file);
						/*BufferedImage newBufferedImage = new BufferedImage(bufImg.getWidth(), bufImg.getHeight(),
								BufferedImage.TYPE_INT_RGB);
						newBufferedImage.createGraphics().drawImage(bufImg, 0, 0, Color.WHITE, null);*/

						// write to jpeg file
						file = new File("/tmp/sample.jpg");
						ImageIO.write(bufImg, "jpg", file);
						Image img = Image.getInstance(file.getAbsolutePath());
				    	System.out.println("Absolute Path : " + file.getAbsolutePath());
				    	//if you would have a chapter indentation
				    	int indentation = 150;
				    	int indentationY = 200;
				    	//whatever
				    	Image image = img;

				    	float scalerX = ((document.getPageSize().getWidth() - document.leftMargin()
				    	               - document.rightMargin() - indentation) / image.getWidth()) * 100;
				    	
				    	float scalerY = ((document.getPageSize().getHeight() - document.topMargin()
			    	               - document.bottomMargin() - indentationY) / image.getHeight()) * 100;

				    	image.scalePercent(scalerX, scalerY);
				    	//img.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
				    	//img.scaleToFit(530f, 700f);
				    	img.setAlignment(Image.ALIGN_CENTER);
					    document.add(img);
					    document.add(new Paragraph("\nStep Result: \nComments :\nEnd Time : " + System.currentTimeMillis()));
			    	}catch(Exception e) {
			        	System.out.println(e);
			        }
			    });
			    System.out.println("Document hascode : " + document.hashCode() + " with HexString as : " + Integer.toHexString(document.hashCode()) + " and object is : " + document);
			    document.close();
			    /*PdfReader pdfReader = new PdfReader(fileName + "/pdfWithImae.pdf");
			    PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(fileName + "/output.pdf"));
			    pdfReader.removeFields();
			    pdfReader.removeUnusedObjects();
			    int total = pdfReader.getNumberOfPages() + 1;
			    for ( int i=1; i<total; i++) {
			    	pdfReader.setPageContent(i + 1, pdfReader.getPageContent(i + 1));
			    }
			    pdfStamper.setFullCompression();
			    pdfStamper.close();*/
			    //manipulatePdf(fileName + "/pdfWithImae.pdf", fileName + "/output.pdf");
			    System.out.println("File Size : " + (float)(new File(fileName + "/pdfWithImae.pdf").length())/(1024*1024) + "MB");
	        
	    }

	 
	private static Image compressImage(File file) throws Exception {
		// Image Processing for Landscape
		BufferedImage bufferedImage = ImageIO.read(file);
		AffineTransform tx = new AffineTransform();
		// last, width = height and height = width
		//tx.translate(bufferedImage.getHeight() / 2, bufferedImage.getWidth() / 2);
		//tx.rotate(Math.PI / 2);
		// first - center image at the origin so rotate works OK
		//tx.translate(-bufferedImage.getWidth() / 2, -bufferedImage.getHeight() / 2);

		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

		// new destination image where height = width and width = height.
		BufferedImage newImage = new BufferedImage(bufferedImage.getHeight(), bufferedImage.getWidth(),
				bufferedImage.getType());
		op.filter(bufferedImage, newImage);
		File output = null;
		final ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			output = new File("/tmp/reduce.png");
			ImageIO.write(newImage, "png", output);
			//uri = os.toString(StandardCharsets.ISO_8859_1.name());
		} catch (final IOException ioe) {
			throw new UncheckedIOException(ioe);
		}
		return Image.getInstance(output.getAbsolutePath());
	}
	
	public static void reduceImageQuality(int sizeThreshold, File file, String destImg) throws Exception {  
        float quality = 1.0f;  
  
        long fileSize = file.length();  
  
        if (fileSize <= sizeThreshold) {  
            System.out.println("Image file size is under threshold");  
            return;  
        }  
  
        Iterator iter = ImageIO.getImageWritersByFormatName("jpeg");  
  
        ImageWriter writer = (ImageWriter)iter.next();  
  
        ImageWriteParam iwp = writer.getDefaultWriteParam();  
  
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);  
  
        FileInputStream inputStream = new FileInputStream(file);  
  
        BufferedImage originalImage = ImageIO.read(inputStream);  
        IIOImage image = new IIOImage(originalImage, null, null);  
  
        float percent = 0.1f;   // 10% of 1  
  
        while (fileSize > sizeThreshold) {  
            if (percent >= quality) {  
                percent = percent * 0.1f;  
            }  
  
            quality -= percent;  
  
            File fileOut = new File(destImg);  
            if (fileOut.exists()) {  
                fileOut.delete();  
            }  
            FileImageOutputStream output = new FileImageOutputStream(fileOut);  
  
            writer.setOutput(output);  
  
            iwp.setCompressionQuality(quality);  
  
            writer.write(null, image, iwp);  
  
            File fileOut2 = new File(destImg);  
            long newFileSize = fileOut2.length();  
            if (newFileSize == fileSize) {  
                // cannot reduce more, return  
                break;  
            } else {  
                fileSize = newFileSize;  
            }  
            System.out.println("quality = " + quality + ", new file size = " + fileSize);  
            output.close();  
        }  
  
        writer.dispose();  
    }
	 
	 public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
	        PdfReader reader = new PdfReader(src);
	        int n = reader.getXrefSize();
	        PdfObject object;
	        PRStream stream;
	        float FACTOR = 0.5f;
	        // Look for image and manipulate image stream
	        for (int i = 0; i < n; i++) {
	            object = reader.getPdfObject(i);
	            if (object == null || !object.isStream())
	                continue;
	            stream = (PRStream)object;
	            if (!PdfName.IMAGE.equals(stream.getAsName(PdfName.SUBTYPE)))
	                continue;
	            if (!PdfName.DCTDECODE.equals(stream.getAsName(PdfName.FILTER)))
	                continue;
	            PdfImageObject image = new PdfImageObject(stream);
	            BufferedImage bi = image.getBufferedImage();
	            if (bi == null)
	                continue;
	            int width = (int)(bi.getWidth() * FACTOR);
	            int height = (int)(bi.getHeight() * FACTOR);
	            if (width <= 0 || height <= 0)
	                continue;
	            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	            AffineTransform at = AffineTransform.getScaleInstance(FACTOR, FACTOR);
	            Graphics2D g = img.createGraphics();
	            g.drawRenderedImage(bi, at);
	            ByteArrayOutputStream imgBytes = new ByteArrayOutputStream();
	            ImageIO.write(img, "JPG", imgBytes);
	            stream.clear();
	            stream.setData(imgBytes.toByteArray(), false, PRStream.NO_COMPRESSION);
	            stream.put(PdfName.TYPE, PdfName.XOBJECT);
	            stream.put(PdfName.SUBTYPE, PdfName.IMAGE);
	            stream.put(PdfName.FILTER, PdfName.DCTDECODE);
	            stream.put(PdfName.WIDTH, new PdfNumber(width));
	            stream.put(PdfName.HEIGHT, new PdfNumber(height));
	            stream.put(PdfName.BITSPERCOMPONENT, new PdfNumber(8));
	            stream.put(PdfName.COLORSPACE, PdfName.DEVICERGB);
	        }
	        reader.removeUnusedObjects();
	        // Save altered PDF
	        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
	        stamper.setFullCompression();
	        stamper.close();
	        reader.close();
	    }
	 
	 private static void createDir(String dirName) {
	        File file = new File(dirName);
	        try {
	            if (!file.exists()) {
	                file.mkdirs();
	                file.setExecutable(true);
	                file.setReadable(true);
	                file.setWritable(true);
	                System.out.println("Directory Created :: " + dirName);
	            }
	        } catch (Exception e) {
	        	System.out.println("Unable to create directory with " + dirName);
	        }
	    }
	 
	 static class HeaderFooterPageEvent extends PdfPageEventHelper {
		 	final String VL_LOGO = "/home/chiranjeevi/Downloads/valuelabs_logo.png";
		 	LineSeparator UNDERLINE = new LineSeparator(1, 100, null, Element.ALIGN_BOTTOM, -2);

		    public void onStartPage(PdfWriter writer, Document document) {
		        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("UTMS"), 55, 810, 0);
		        //ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("ValueLabs"), 530, 810, 0);
			    try {
			    	Image img = Image.getInstance(VL_LOGO);
			    	img.setAbsolutePosition(490, 810);
			    	img.scalePercent(55f);
			    	document.add(img);
			    	UNDERLINE.drawLine(writer.getDirectContent(), 30, 800, 0);
			    	document.add(UNDERLINE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

		    public void onEndPage(PdfWriter writer, Document document) {
		    	UNDERLINE.drawLine(writer.getDirectContent(), 30, 560, 50);
		        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Page - " + document.getPageNumber()), 275, 30, 0);
		    }

		}
}
