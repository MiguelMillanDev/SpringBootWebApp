package es.magicwater.servicios;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import es.magicwater.jpa.Tarea;
import es.magicwater.repositorios.TareaRepositorio;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.io.IOException;


@Service
public class PDFService {

    @Autowired
    private TareaRepositorio tareaRepositorio;

    public void exportarTareasPDF(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=tareas.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        List<Tarea> tareasPendientes = tareaRepositorio.findByEstado("Pendiente");
        List<Tarea> tareasFinalizadas = tareaRepositorio.findByEstado("Finalizada");

        agregarTareas(document, "Tareas Pendientes", tareasPendientes);
        agregarTareas(document, "Tareas Finalizadas", tareasFinalizadas);

        document.close();
    }

    private void agregarTareas(Document document, String titulo, List<Tarea> tareas) throws DocumentException {
        document.add(new Paragraph(titulo));
        for (Tarea tarea : tareas) {
            document.add(new Paragraph(tarea.getTitulo()));
            document.add(new Paragraph(tarea.getDescripcion()));

        }
    }
}