package dev.encurtador.encurtador.Links;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/encurtador")
    public ResponseEntity<LinkResponse> gerarUrlEncurtada(@RequestBody Map<String, String> request){
        String urlOriginal = request.get("urlOriginal");
        Links link = linkService.encurtarUrl(urlOriginal);

        String gerarUrlDeRedirecionamentoDoUsuario = "http://localhost:8080/r/" + link.getUrlEncurtada();

        LinkResponse response = new LinkResponse(
                link.getId(),
                link.getUrlLonga(),
                gerarUrlDeRedirecionamentoDoUsuario,
                link.getUrlQrCode(),
                link.getUrlCreatedAt()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

@GetMapping("/r/{urlEncurtada}")
    public void redirecionarLink(@PathVariable String urlEncurtada, HttpServletResponse response) throws IOException {

        Links link = linkService.obterUrlOriginal(urlEncurtada);

        if(link != null){
            response.sendRedirect(link.getUrlLonga());
        }else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
