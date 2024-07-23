package dev.encurtador.encurtador.Links;

import java.time.LocalDateTime;

public class LinkResponse {

    private Long id;
    private String urlLonga;
    private String urlEncurtada;
    private String urlQrCode;
    private LocalDateTime urlCreatedAt;

    public LinkResponse(Long id, String urlLonga, String urlEncurtada, String urlQrCode, LocalDateTime urlCreatedAt) {
        this.id = id;
        this.urlLonga = urlLonga;
        this.urlEncurtada = urlEncurtada;
        this.urlQrCode = urlQrCode;
        this.urlCreatedAt = urlCreatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlLonga() {
        return urlLonga;
    }

    public void setUrlLonga(String urlLonga) {
        this.urlLonga = urlLonga;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }

    public LocalDateTime getUrlCreatedAt() {
        return urlCreatedAt;
    }

    public void setUrlCreatedAt(LocalDateTime urlCreatedAt) {
        this.urlCreatedAt = urlCreatedAt;
    }
}
