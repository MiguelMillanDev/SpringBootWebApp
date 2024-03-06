package es.magicwater.controladores;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import es.magicwater.jpa.Tarea;
import es.magicwater.jpa.Usuario;
import es.magicwater.repositorios.TareaRepositorio;
import es.magicwater.repositorios.UsuarioRepositorio;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pdf")
public class PDFController {

    @Autowired
    private TareaRepositorio tareaRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/exportar-tareas")
    public void exportarTareas(HttpServletResponse response) throws IOException {
        List<Tarea> tareasPendientes = tareaRepositorio.findByEstado("Pendiente");
        List<Tarea> tareasFinalizadas = tareaRepositorio.findByEstado("Finalizada");
        List<Usuario> usuarios = usuarioRepositorio.findAll();

        // Crear un nuevo documento PDF
        Document document = new Document();

        try {
            // Configurar la respuesta HTTP para indicar que se está enviando un archivo PDF
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"tareas.pdf\"");

            // Crear un escritor de PDF y escribir el contenido en la respuesta HTTP
            PdfWriter.getInstance(document, response.getOutputStream());

            // Abrir el documento para agregar contenido
            document.open();

            // Agregar título
            document.add(new Paragraph("Tareas Pendientes:"));
            // Agregar tareas pendientes al documento
            for (Tarea tarea : tareasPendientes) {
                document.add(new Paragraph(tarea.getTitulo()));
                document.add(new Paragraph(tarea.getDescripcion()));
                document.add(new Paragraph("--------------------"));
            }

            // Agregar título
            document.add(new Paragraph("\nTareas Finalizadas:"));
            // Agregar tareas finalizadas al documento
            for (Tarea tarea : tareasFinalizadas) {
                document.add(new Paragraph(tarea.getTitulo()));
                document.add(new Paragraph(tarea.getDescripcion()));
                document.add(new Paragraph("--------------------"));
            }
            // Agregar título
            document.add(new Paragraph("\nUsuarios:"));
            // Agregar usuarios al documento
            for (Usuario usuario : usuarios) {
                document.add(new Paragraph(usuario.getNombre() + " " + usuario.getApellidos()));
                document.add(new Paragraph(usuario.getEmail()));
                document.add(new Paragraph("--------------------"));
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } finally {
            // Cerrar el documento
            if (document != null) {
                document.close();
            }
        }
    }
}
