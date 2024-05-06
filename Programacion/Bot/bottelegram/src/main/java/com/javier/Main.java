package com.javier;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import com.itextpdf.text.ListItem; // Import the ListItem class

public class Main {
    public static void main(String[] args) throws MalformedURLException, IOException {
        // Crear documento con dimensiones de carnet
        Document document = new Document();
        try {
            // Escribir en el documento
            PdfWriter.getInstance(document, new FileOutputStream("PrintProManager.pdf"));
            document.open();

            // Añadir imagen en la parte de arriba
            String imagePath = "./image.png"; // Ruta de la imagen
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(imagePath);
            image.scaleToFit(100, 100); // Ajustar imagen al tamaño deseado
            image.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
            document.add(image);

            // Agregar texto debajo de la imagen
            Paragraph paragraph = new Paragraph("PrintPro-Manager", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, BaseColor.BLACK));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(paragraph);

            // Agregar línea negra de lado a lado de la página
            Paragraph line = new Paragraph();
            line.add(new Chunk(new LineSeparator(1, 100, BaseColor.BLACK, Element.ALIGN_CENTER, -1)));
            document.add(line);

            // Agregar título de incidencia
            Paragraph title = new Paragraph("Incidencia 5698", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, BaseColor.DARK_GRAY));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Crear tabla con información del cliente
            String[][] clientInfo = {
                {"Nombre", "John Doe"},
                {"Dirección", "123 Main St"},
                {"Ciudad", "New York"},
                {"País", "USA"},
                {"Teléfono", "555-1234"},
            };
            // Crear tabla y agregar información
            // Crear tabla con información del cliente
            com.itextpdf.text.pdf.PdfPTable clientTable = new com.itextpdf.text.pdf.PdfPTable(2); // 2 columnas
            clientTable.setWidthPercentage(80); // Porcentaje de ancho de la página ocupado por la tabla
            clientTable.setSpacingBefore(20); // Espacio antes de la tabla
            clientTable.setHorizontalAlignment(Element.ALIGN_CENTER); // Centrar el texto dentro de la tabla
            // Agregar celdas a la tabla
            for (String[] row : clientInfo) {
                for (String cell : row) {
                    clientTable.addCell(cell);
                }
            }
            // Agregar tabla de cliente al documento
            document.add(clientTable);

            // Crear tabla con información de la impresora
            String[][] printerInfo = {
                {"Marca", "HP"},
                {"Modelo", "OfficeJet Pro 8710"},
                {"Tipo", "Impresora multifuncional"},
                {"Conexión", "Wi-Fi"},
                {"Resolución", "1200 x 1200 dpi"},
            };

            // Crear tabla y agregar información
            com.itextpdf.text.pdf.PdfPTable table = new com.itextpdf.text.pdf.PdfPTable(2); // 2 columnas
            table.setWidthPercentage(80); // Porcentaje de ancho de la página ocupado por la tabla
            table.setSpacingBefore(20); // Espacio antes de la tabla

            // Agregar celdas a la tabla
            for (String[] row : printerInfo) {
                for (String cell : row) {
                    table.addCell(cell);
                }
            }
            // Agregar tabla al documento
            document.add(table);

            
            // Agregar espacio después de la tabla de cliente
            document.add(new Paragraph("\n"));

            // Agregar cuadrado con descripción
            Paragraph description = new Paragraph("Descripción:", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, BaseColor.DARK_GRAY));
            description.setAlignment(Element.ALIGN_LEFT);
            document.add(description);

            document.add(line);

            // Agregar descripción
            Paragraph description1 = new Paragraph("Esta es una descripción de la incidencia.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK));
            description1.setAlignment(Element.ALIGN_LEFT);
            document.add(description1);

            // Agregar lista de consumibles
            Paragraph consumablesTitle = new Paragraph("Consumibles:", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, BaseColor.DARK_GRAY));
            consumablesTitle.setAlignment(Element.ALIGN_LEFT);
            document.add(consumablesTitle);

            String[] consumables = {
                "Cartucho de tinta negra",
                "Cartucho de tinta cian",
                "Cartucho de tinta magenta",
                "Cartucho de tinta amarilla",
                "Papel tamaño A4"
            };

            List list = new List(List.UNORDERED);
            for (String consumable : consumables) {
                ListItem listItem = new ListItem(); // Use the default constructor
                listItem.add(new com.itextpdf.text.Paragraph(consumable)); // Add the consumable as a Paragraph to the ListItem
                list.add(listItem);
            }

            document.add(list);
            
            document.close();
            System.out.println("PDF creado correctamente.");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

