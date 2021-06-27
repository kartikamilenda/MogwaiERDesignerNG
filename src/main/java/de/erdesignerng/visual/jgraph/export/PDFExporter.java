package de.erdesignerng.visual.jgraph.export;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import de.erdesignerng.visual.jgraph.ERDesignerGraph;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PDFExporter implements Exporter{

    @Override
    public String getFileExtension() {
        return ".pdf";
    }


    @Override
    public void fullExportToStream(ERDesignerGraph aGraph, OutputStream aStream) throws IOException {
            String dest = "D:/PUNYA ADO/addingImage.pdf";
            PdfWriter writer = new PdfWriter(aStream);

            PdfDocument pdf = new PdfDocument(writer);

            Document document = new Document(pdf);

            Color theBackgroundColor = aGraph.getBackground();
            BufferedImage theImage = aGraph.getImage(theBackgroundColor, 10);
            ImageIO.write(theImage, "png", aStream);

            String images = "D:/PUNYA ADO/test.png";
            ImageData data = ImageDataFactory.create(images);

            Image coba = new Image(data);

            document.add(coba);
            document.close();
            aStream.flush();
            aStream.close();

    }

    @Override
    public void exportToStream(Component aComponent, OutputStream aStream) throws IOException {

    }
}
