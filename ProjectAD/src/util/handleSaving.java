package util;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controllers.*;

public class handleSaving {


    public static void handleSave(){

        ObservableList<Predictions> predictions = FXCollections.observableArrayList();

        if (innerScreenController.isLogSelected()){
            predictions = logisticTabController.getPredictions();
        }
        if (innerScreenController.isExpSelected()){
            predictions = exponentialTabController.getPredictions();
        }
        if (innerScreenController.isAgeSelected()){
            predictions = ageTabController.getPredictions();
        }
        if (innerScreenController.isCompSelected()){
            predictions = competitiveTabController.getPredictions();
        }
        if (innerScreenController.isPredSelected()){
            predictions = predationTabController.getPredictions();
        }

        Document document = new Document();
        String desktopPath;
        if (System.getProperty("os.name").startsWith("Windows")) {
            desktopPath = System.getProperty("user.home") + "\\" + "Desktop";
        }
        else{
            desktopPath = System.getProperty("user.home") + "/" + "Desktop";
        }
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(desktopPath + "\\Predictions.pdf"));
            document.open();

            PdfPTable table = new PdfPTable(4);

            PdfPCell c1 = new PdfPCell(new Phrase("Year"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Cattle"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Deer"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Horse"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);

            for(Predictions pred : predictions){
                table.addCell(String.valueOf(pred.getYear()));
                table.addCell(String.valueOf(pred.getCattle()));
                table.addCell(String.valueOf(pred.getDeer()));
                table.addCell(String.valueOf(pred.getHorse()));
            }
            document.add(table);

            if(new File("lineChart.png").exists()){
                com.itextpdf.text.Image lineChartImage = com.itextpdf.text.Image.getInstance("lineChart.png");
                document.add(lineChartImage);
            }
            if(new File("pieChart.png").exists()) {
                com.itextpdf.text.Image pieChartImage = com.itextpdf.text.Image.getInstance("pieChart.png");
                document.add(pieChartImage);
            }

            document.close();
            writer.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
