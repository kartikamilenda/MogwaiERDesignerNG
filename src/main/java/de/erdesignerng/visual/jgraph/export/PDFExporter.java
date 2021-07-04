package de.erdesignerng.visual.jgraph.export;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

import de.erdesignerng.visual.jgraph.ERDesignerGraph;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.*;
import java.io.ByteArrayOutputStream;

import java.io.OutputStream;


public class PDFExporter implements Exporter{

    @Override
    public String getFileExtension() {
        return ".pdf";
    }


    @Override
    public void fullExportToStream(ERDesignerGraph aGraph, OutputStream aStream) throws IOException, DocumentException {
        Color theBackgroundColor = aGraph.getBackground();
        BufferedImage theImage = aGraph.getImage(theBackgroundColor, 10);
        ByteArrayOutputStream imagepng = new ByteArrayOutputStream();
        ImageIO.write(theImage, "png", imagepng);

        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document,aStream);
        document.open();

        Image image = Image.getInstance(imagepng.toByteArray());

        document.add(image);
        document.close();
    }

    @Override
    public void exportToStream(Component aComponent, OutputStream aStream) throws IOException {

    }
}
