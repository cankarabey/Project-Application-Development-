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

        String pdfName = "";
        if (innerScreenController.isLogSelected()){
            predictions = logisticTabController.getPredictions();
            pdfName = "Logistic";
        }
        if (innerScreenController.isExpSelected()){
            predictions = exponentialTabController.getPredictions();
            pdfName = "Exponential";
        }
        if (innerScreenController.isAgeSelected()){
            predictions = ageTabController.getPredictions();
            pdfName = "Age";
        }
        if (innerScreenController.isCompSelected()){
            predictions = competitiveTabController.getPredictions();
            pdfName = "Competetive";
        }
        if (innerScreenController.isPredSelected()){
            predictions = predationTabController.getPredictions();
            pdfName = "Predation";
        }
        if (innerScreenController.isGrassSelected()){
            predictions = grassTabController.getPredictions();
            pdfName = "Grass";
        }

        Document document = new Document();
        String desktopPath;
        if (System.getProperty("os.name").startsWith("Windows")) {
            desktopPath = System.getProperty("user.home") + "\\" + "Desktop\\";
        }
        else{
            desktopPath = System.getProperty("user.home")+ "/";
        }

        if(!pdfName.equals("Grass")){
            try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(desktopPath  + pdfName +  "Predictions.pdf"));
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
        } else {
            try{
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(desktopPath + "\\" + pdfName +  "Predictions.pdf"));
                document.open();

                PdfPTable table = new PdfPTable(2);

                PdfPCell c1 = new PdfPCell(new Phrase("Year"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Weight"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                table.setHeaderRows(1);

                for(Predictions pred : predictions){
                    table.addCell(String.valueOf(pred.getYear()));
                    table.addCell(String.valueOf(pred.getWeight()));
                }
                document.add(table);

                if(new File("barChart.png").exists()){
                    com.itextpdf.text.Image barChartImage = com.itextpdf.text.Image.getInstance("barChart.png");
                    document.add(barChartImage);
                }

                document.close();
                writer.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
